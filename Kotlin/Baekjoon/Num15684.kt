// 백준 - 사다리 조작(15684)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var N = 0
var H = 0
var lines = arrayOf<Array<Boolean>>()

var isFinished = false

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  N = st.nextToken().toInt()
  val M = st.nextToken().toInt()
  H = st.nextToken().toInt()

  lines = Array(N + 1, {Array(H + 1, {false})})

  for(i: Int in 0..M-1) {
    st = StringTokenizer(br.readLine())
    val y = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    lines[x][y] = true // x번 세로선에서 y번 위치
  }

  var answer = -1

  // 사다리를 0~3개 추가하는 경우의 수
  for(i: Int in 0..3) {
    dfs(0, i)
    if(isFinished) {
      answer = i
      break
    }
  }

  print(answer)
}
// 가로선 추가
fun dfs(addLine: Int, goalAddLine: Int) {
  if(isFinished) return
  if(addLine == goalAddLine) {
    if(checkFinish()) isFinished = true
    return
  }

  for(j: Int in 1..H) {
    for(i: Int in 1..N-1) {
      // 가로선이 없는 위치인가 + 가로선이 연속되지 않도록 양쪽에 연결되어 있는 가로선이 있는지 체크
      if(!lines[i][j] && !lines[i-1][j] && !lines[i+1][j]) {
        // 가로선 추가
        lines[i][j] = true

        dfs(addLine + 1, goalAddLine)

        // 가로선 제거
        lines[i][j] = false
      }
    }
  }
}

// i번에서 출발해서 i번에 도착하는 조건이 만족하는지 확인
fun checkFinish() : Boolean {
  for(i: Int in 1..N) {
    var currentX = i
    var currentY = 1

    while(currentY <= H) {
      // 우측으로 이동 가능
      if(currentX < N && lines[currentX][currentY]) currentX++
      // 좌측으로 이동 가능
      else if(currentX > 1 && lines[currentX - 1][currentY]) currentX--

      // 아래로 이동
      currentY++
    }

    // i번에 도착하지 않음
    if(currentX != i) return false
  }

  return true
}