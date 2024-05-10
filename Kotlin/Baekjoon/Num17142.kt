// 백준 - 연구소 3(17142)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

data class Virus(
  var x: Int,
  var y: Int,
  var time: Int
)

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var N = 0
var K = 0

var map: Array<Array<Int>> = arrayOf()
var virusPoint: MutableList<Virus> = mutableListOf() // 바이러스 위치
var selected: Array<Boolean> = arrayOf() // 활성할 바이러스
var visited: Array<Array<Boolean>> = arrayOf() // 활성 여부

var minTime = 0 // 최소 시간
var empty = 0   // 빈 칸 수

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  N = st.nextToken().toInt()
  K = st.nextToken().toInt()

  minTime = N * N // 시간의 최대값

  map = Array(N, {Array(N, {0})})

  for(i: Int in 0..N-1) {
    st = StringTokenizer(br.readLine())
    for(j: Int in 0..N-1) {
      map[i][j] = st.nextToken().toInt()
      // 빈공간 개수
      if(map[i][j] == 0) empty++
      // 바이러스 위치
      else if(map[i][j] == 2) virusPoint.add(Virus(i, j, 0))
    }
  }

  // 빈칸 없으면 바로 종료
  if(empty == 0) {
    print(0)
    return
  }
  
  selected = Array(virusPoint.size, {false})
  selectVirus(0, 0) // 활성 바이러스 K개 선택

  // 모든 빈 칸에 바이러스를 확산시킬 수 없을 경우
  if(minTime == N * N) {
    minTime = -1
  }

  print(minTime)
}
// 활성 바이러스 K개 선택
fun selectVirus(start: Int, cnt: Int) {
  // K개를 선택했다면
  if(cnt == K) {
    activeVirus()

    return
  }

  for(i: Int in start..(virusPoint.size - 1)) {
    // 선택
    selected[i] = true
    selectVirus(i + 1, cnt + 1)
    selected[i] = false
  }
}

// 바이러스 활성 시작
fun activeVirus() {
  val queue = LinkedList<Virus>() as Queue<Virus>
  visited = Array(N, {Array(N, {false})})

  // 활성할 바이러스 queue에 삽입
  for(i: Int in 0..(virusPoint.size - 1)) {
    if(selected[i]) {
      queue.offer(virusPoint[i])
      visited[virusPoint[i].x][virusPoint[i].y] = true
    }
  }

  var time = 0
  var vCnt = 0 // 확산된 바이러스 칸 수

  while(!queue.isEmpty()) {
    var cur = queue.poll()

    // 바이러스를 상하좌우로 활성화
    for(i: Int in 0..3) {
      val moveX = cur.x + dx[i]
      val moveY = cur.y + dy[i]

      time = cur.time + 1

      // 범위를 벗어나거나 이미 방문했거나, 벽인 경우
      if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N || visited[moveX][moveY] || map[moveX][moveY] == 1) continue

      // 확산 or 비활성 바이러스를 활성화
      visited[moveX][moveY] = true
      queue.offer(Virus(moveX, moveY, time))

      // 확산 전 빈칸이었다면
      if(map[moveX][moveY] == 0)
        vCnt++
    }

    // 모든 빈칸이 확산된 경우
    if(vCnt == empty) break
  }

  // 빈칸을 다 못 채운 경우
  if(vCnt != empty) return

  minTime = min(minTime, time) 
}