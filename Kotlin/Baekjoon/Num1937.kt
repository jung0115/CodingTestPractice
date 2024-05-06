// 백준 - 욕심쟁이 판다(1937)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var N = 0
var bamboo: Array<Array<Int>> = Array(1, {Array(1, {0})})
var dp: Array<Array<Int>> = Array(1, {Array(1, {0})})

var maxMove = 0

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  N = br.readLine().toInt()

  bamboo = Array(N, {Array(N, {0})})
  dp = Array(N, {Array(N, {0})})

  for(i: Int in 0..N-1) {
    val st = StringTokenizer(br.readLine())
    for(j: Int in 0..N-1) {
      bamboo[i][j] = st.nextToken().toInt()
    }
  }

  // 모든 칸마다 출발지점으로 했을 때 최대 이동칸수 구하고 그 중 최대값 찾기
  for(i: Int in 0..N-1) {
    for(j: Int in 0..N-1) {
      maxMove = max(dfs(i, j), maxMove)
    }
  }

  print(maxMove)
}

// 판다 이동
fun dfs(x: Int, y: Int) : Int {
  // 이미 방문했던 값이 있다면
  if(dp[x][y] != 0) return dp[x][y]

  // 현재 칸은 무조건 먹기 때문에 1
  dp[x][y] = 1

  // 상하좌우 이동
  for(i: Int in 0..3) {
    val moveX = x + dx[i]
    val moveY = y + dy[i]

    // 공간을 벗어나면 패스
    if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N) continue

    // 현재 위치보다 대나무가 더 많은 경우 이동
    if(bamboo[x][y] < bamboo[moveX][moveY]) {
      // 해당 방향으로 이동한 것과 아닌 것 중 판다가 더 많이 이동하는 경우를 저장
      dp[x][y] = max(dp[x][y], dfs(moveX, moveY) + 1)
    }
  }

  return dp[x][y]
}