// 백준 - 테트로미노(14500)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

var N = 0
var M = 0
var maxSum = 0

var paper: Array<Array<Int>> = arrayOf()
var visited: Array<Array<Boolean>> = arrayOf()

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  N = st.nextToken().toInt()
  M = st.nextToken().toInt()

  paper = Array(N, {Array(M, {0})})
  visited = Array(N, {Array(M, {false})})

  for(i: Int in 0..N-1) {
    st = StringTokenizer(br.readLine())
    for(j: Int in 0..M-1) {
      paper[i][j] = st.nextToken().toInt()
    }
  }

  // 모든 지점에서 출발해보기
  for(i: Int in 0..N-1) {
    for(j: Int in 0..M-1) {
      visited[i][j] = true
      maxTetromino(i, j, paper[i][j], 1)
      visited[i][j] = false
    }
  }

  print(maxSum)
}

// 상하좌우 움직임으로 4개 정사각형 합 찾기
fun maxTetromino(x: Int, y: Int, sum: Int, cnt: Int) {
  // 테트로미노 완성
  if(cnt == 4) {
    maxSum = max(sum, maxSum) // 최대값 구하기
    return
  }

  for(i: Int in 0..3) {
    val moveX = x + dx[i]
    val moveY = y + dy[i]

    // 범위 벗어나면 패스
    if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) continue

    // 현재 조합 중인 테트로미노 조각에 포함되지 않은 경우
    if(!visited[moveX][moveY]) {
      // ㅗ, ㅜ, ㅏ, ㅓ 모양 테트로미노는 중간에 양쪽으로 갈리기 때문에
      // 중간에 현재 위치에서 다른 방향으로 이동하도록
      if(cnt == 2) {
        visited[moveX][moveY] = true
        maxTetromino(x, y, sum + paper[moveX][moveY], cnt + 1)
        visited[moveX][moveY] = false
      }
      visited[moveX][moveY] = true
      maxTetromino(moveX, moveY, sum + paper[moveX][moveY], cnt + 1)
      visited[moveX][moveY] = false
    }
  }
}