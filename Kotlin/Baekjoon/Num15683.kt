// 백준 - 감시(15683)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// cctv 감시 방향 - 위, 오른쪽, 아래, 왼쪽
val dir = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1))

var N = 0
var M = 0
var minCnt = 0 // 사각지대 크기 최소값

data class CCTV (
  val x: Int,
  val y: Int,
  val num: Int // cctv 번호
)

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  N = st.nextToken().toInt() // 세로
  M = st.nextToken().toInt() // 가로

  minCnt = N * M // 최대로 나올 수 있는 사각지대 크기

  var map: Array<Array<Int>> = Array(N, {Array(M, {0})})   // 사무실
  var cctvMap : MutableList<CCTV> = mutableListOf<CCTV>()  // 1~4번 cctv 위치
  var cctv5Map : MutableList<CCTV> = mutableListOf<CCTV>() // 5번 cctv 위치

  // 사무실 각 칸의 정보
  for(i : Int in 0..N-1) {
    st = StringTokenizer(br.readLine())
    for(j : Int in 0..M-1) {
      map[i][j] = st.nextToken().toInt()

      // CCTV 위치는 따로 보관
      if(map[i][j] >= 1 && map[i][j] <= 4) {
        cctvMap.add(CCTV(i, j, map[i][j]))
      }
      // 5번 CCTV는 따로
      if(map[i][j] == 5) {
        cctv5Map.add(CCTV(i, j, map[i][j]))
      }
    }
  }

  // 5번 cctv가 감시하는 곳은 일단 다 표시해두고 1~4번만 방향을 돌리면서 경우의 수 비교
  for(i : Int in 0..cctv5Map.size - 1) {
    // 상하좌우 모든 방향으로 감시
    for(j: Int in 0..3) {
      checkCCTV(map, j, cctv5Map[i].x, cctv5Map[i].y)
    }
  }

  // 1~4번 cctv에 대해서 체크
  dfsCCTV(map, cctvMap, 0)

  print(minCnt)
}

// 1~4번 cctv에 대해서 체크 -----------------------------------------------------------------
fun dfsCCTV(map: Array<Array<Int>>, cctvMap : MutableList<CCTV>, idx: Int) {
  // 모든 CCTV의 감시를 다 체크했으면
  if(idx == cctvMap.size) {
    // 사각지대 최소값 확인
    val cnt = countBlind(map)
    if(minCnt > cnt) minCnt = cnt

    return
  }

  var x: Int = cctvMap[idx].x
  var y: Int = cctvMap[idx].y
  var cctvNum: Int = cctvMap[idx].num

  var copy: Array<Array<Int>>

  // 1번 CCTV
  if(cctvNum == 1) {
    for(i: Int in 0..3) {
      // 한 방향으로 감시
      copy = copyMap(map)
      checkCCTV(copy, i, x, y)

      dfsCCTV(copy, cctvMap, idx + 1)
    }
  }

  // 2번 CCTV
  else if(cctvNum == 2) {
    for(i: Int in 0..1) {
      // 양쪽 두 방향으로 감시
      copy = copyMap(map)
      checkCCTV(copy, i, x, y)
      checkCCTV(copy, (i + 2) % 4, x, y)

      dfsCCTV(copy, cctvMap, idx + 1)
    }
  }

  // 3번 CCTV
  else if(cctvNum == 3) {
    for(i: Int in 0..3) {
      // 이어진 두 직각 방향으로 감시
      copy = copyMap(map)
      checkCCTV(copy, i, x, y)
      checkCCTV(copy, (i + 1) % 4, x, y)

      dfsCCTV(copy, cctvMap, idx + 1)
    }
  }

  // 4번 CCTV
  else if(cctvNum == 4) {
    for(i: Int in 0..3) {
      // 한쪽 빼고 세 방향으로 감시
      copy = copyMap(map)
      checkCCTV(copy, i, x, y)
      checkCCTV(copy, (i + 1) % 4, x, y)
      checkCCTV(copy, (i + 2) % 4, x, y)

      dfsCCTV(copy, cctvMap, idx + 1)
    }
  }
}

// 감시 체크 - d: 감시 방향 -----------------------------------------------------------------
fun checkCCTV(map: Array<Array<Int>>, d: Int, x: Int, y: Int) {
  var moveX = x + dir[d][0]
  var moveY = y + dir[d][1]

  while(true) {
    // 공간을 벗어나거나 벽을 만나면 중단
    if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M || map[moveX][moveY] == 6) 
      break;
    
    // 아직 감시 안 한 곳이면 체크
    // cctv가 감시하는 곳은 -1로 표시
    else if(map[moveX][moveY] == 0)
      map[moveX][moveY] = -1
    
    // 해당 방향으로
    moveX = moveX + dir[d][0]
    moveY = moveY + dir[d][1]
  }
}

// map 복사 -----------------------------------------------------------------
fun copyMap(map: Array<Array<Int>>) : Array<Array<Int>> {
  return Array(N) { n ->
    Array<Int>(M) { m ->
      map[n][m]
    }
  }
}

// 사각지대 크기 -----------------------------------------------------------------
fun countBlind(map: Array<Array<Int>>) : Int {
  var cnt = 0

  for(i : Int in 0..N-1) {
    for(j : Int in 0..M-1) {
      // CCTV가 감시하지 않는 부분
      if(map[i][j] == 0)
        cnt++
    }
  }

  return cnt
}