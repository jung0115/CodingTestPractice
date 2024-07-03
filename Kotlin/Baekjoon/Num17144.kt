// 백준 - 미세먼지 안녕!(17144)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Dust(
  var current: Int,
  var next: Int = 0
)

val dr = arrayOf(0, -1, 0, 1)
val dc = arrayOf(1, 0, -1, 0)

val dr2 = arrayOf(0, 1, 0, -1)
val dc2 = arrayOf(1, 0, -1, 0)

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val R = st.nextToken().toInt() // 행 크기
  val C = st.nextToken().toInt() // 열 크기
  var T = st.nextToken().toInt() // 시간

  // 공기청정기 위치
  var airCleaner = -1
  
  val map = Array(R, {Array(C, {Dust(0)})})
  for(i: Int in 0..R-1) {
    st = StringTokenizer(br.readLine())
    for(j: Int in 0..C-1) {
      map[i][j].current = st.nextToken().toInt()
    }

    if(map[i][0].current == -1) {
      if(airCleaner == -1) airCleaner = i
      map[i][0].current = 0
    }
  }

  while(T > 0) {
    T--

    // 미세먼지 확산
    for(r: Int in 0..R-1) {
      for(c: Int in 0..C-1) {
        var dustSpread: Int = map[r][c].current / 5

        for(i: Int in 0..3) {
          val moveR = r + dr[i]
          val moveC = c + dc[i]

          // 범위를 벗어나거나 공기청정기가 있다면 건너뛰기
          if(moveR < 0 || moveR >= R || moveC < 0 || moveC >= C
            || (moveC == 0 && (moveR == airCleaner || moveR == airCleaner + 1))) continue

          map[moveR][moveC].next += dustSpread
          map[r][c].current -= dustSpread
        }
      }
    }

    for(r: Int in 0..R-1) {
      for(c: Int in 0..C-1) {
        map[r][c].current += map[r][c].next
        map[r][c].next = 0
      }
    }

    // 공기청정기 작동
    // 위쪽 - 반시계 방향
    var currentR = airCleaner
    var currentC = 0
    var currentDust = 0
    for(i: Int in 0..3) {
      while (true) {
        currentR += dr[i]
        currentC += dc[i]

        // 범위 벗어날 경우 순환 방향 전환
        if(currentR < 0 || currentR > airCleaner || currentC < 0 || currentC >= C) {
          currentR -= dr[i]
          currentC -= dc[i]
          break
        }

        // 미세먼지 이동
        var temp = map[currentR][currentC].current
        map[currentR][currentC].current = currentDust
        currentDust = temp
      }
    }

    map[airCleaner][0].current = 0

    // 아래쪽 - 시계 방향
    currentR = airCleaner + 1
    currentC = 0
    currentDust = 0
    for(i: Int in 0..3) {
      while (true) {
        currentR += dr2[i]
        currentC += dc2[i]

        // 범위 벗어날 경우 순환 방향 전환
        if(currentR < airCleaner + 1 || currentR >= R || currentC < 0 || currentC >= C) {
          currentR -= dr2[i]
          currentC -= dc2[i]
          break
        }

        // 미세먼지 이동
        var temp = map[currentR][currentC].current
        map[currentR][currentC].current = currentDust
        currentDust = temp
      }
    }

    map[airCleaner + 1][0].current = 0
  }

  var answer = 0
  for(r: Int in 0..R-1) {
    for(c: Int in 0..C-1) {
      answer += map[r][c].current
    }
  }

  print(answer)
}