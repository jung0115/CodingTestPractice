// 백준 - 내려가기(2096) - 시간초과
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

var N = 0
var map: Array<Array<Int>> = arrayOf()

var maxScore = 0
var minScore = 900000

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  N = br.readLine().toInt()

  map = Array(N, {Array(3, {0})})

  for(i: Int in 0..N-1) {
    val st = StringTokenizer(br.readLine())
    for(j: Int in 0..2) {
      map[i][j] = st.nextToken().toInt()
    }
  }

  calculate(1, map[0][0], 0)
  calculate(1, map[0][1], 1)
  calculate(1, map[0][2], 2)

  print(maxScore.toString() + " " + minScore.toString())
}
// idx: 현재 몇 번째 줄인지, sum: 합, pre: 이전에 선택한 숫자칸
fun calculate(idx: Int, sum: Int, pre: Int) {
  if(idx == N) {
    maxScore = max(maxScore, sum)
    minScore = min(minScore, sum)
    return
  }

  if(pre != 2) calculate(idx + 1, sum + map[idx][0], 0)
  calculate(idx + 1, sum + map[idx][1], 1)
  if(pre != 0) calculate(idx + 1, sum + map[idx][2], 2)
}