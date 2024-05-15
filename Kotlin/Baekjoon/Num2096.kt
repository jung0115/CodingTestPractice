// 백준 - 내려가기(2096)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val N = br.readLine().toInt()

  val map = Array(N, {Array(3, {0})})

  for(i: Int in 0..N-1) {
    val st = StringTokenizer(br.readLine())
    for(j: Int in 0..2) {
      map[i][j] = st.nextToken().toInt()
    }
  }

  val maxDp = Array(N, {Array(3, {0})})
  val minDp = Array(N, {Array(3, {0})})

  // 첫번째 줄 초기값
  for(i: Int in 0..2) {
    maxDp[0][i] = map[0][i]
    minDp[0][i] = map[0][i]
  }

  // 두번째 줄부터 계산
  // 0번이면 위에서 0, 1번이었음 / 1번이면 위에서 0, 1, 2번 / 2번이면 위에서 1, 2번
  for(i: Int in 1..N-1) {
    maxDp[i][0] = max(maxDp[i - 1][0], maxDp[i - 1][1]) + map[i][0]
    maxDp[i][1] = max(maxDp[i - 1][0], max(maxDp[i - 1][1], maxDp[i - 1][2])) + map[i][1]
    maxDp[i][2] = max(maxDp[i - 1][1], maxDp[i - 1][2]) + map[i][2]

    minDp[i][0] = min(minDp[i - 1][0], minDp[i - 1][1]) + map[i][0]
    minDp[i][1] = min(minDp[i - 1][0], min(minDp[i - 1][1], minDp[i - 1][2])) + map[i][1]
    minDp[i][2] = min(minDp[i - 1][1], minDp[i - 1][2]) + map[i][2]
  }

  // 마지막 줄에서 0, 1, 2번 중 최대/최소값
  var maxScore = max(maxDp[N - 1][0], max(maxDp[N - 1][1], maxDp[N - 1][2]))
  var minScore = min(minDp[N - 1][0], min(minDp[N - 1][1], minDp[N - 1][2]))

  print(maxScore.toString() + " " + minScore.toString())
}