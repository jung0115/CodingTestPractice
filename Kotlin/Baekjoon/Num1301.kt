// 백준 - 비즈 공예(1301)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

// 7차원
// 구슬 1~5번의 남은 개수 + 이전 구슬, 전전 구슬
// [1번][2번][3번][4번][5번][전][전전]
var dp = Array(11, { Array(11, { Array(11, { Array(11, { Array(11, { Array(11, { LongArray(11, {-1}) }) }) }) }) }) })

fun dpBeads(beads: Array<Int>, pre: Int, prepre: Int): Long {
  // 구슬을 다 썼을 경우
  if(beads[1] == 0 && beads[2] == 0 && beads[3] == 0 && beads[4] == 0 && beads[5] == 0) return 1

  var cur: Long = dp[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][pre][prepre]
  // 이미 값이 있을 경우
  if(cur != -1L) return cur

  cur = 0L
  for(i: Int in 1..5) {
    // 연속된 3개의 구슬의 색이 모두 다를 때
    if(pre != i && prepre != i && beads[i] > 0) {
      beads[i]--
      cur += dpBeads(beads, i, pre)
      beads[i]++
    }
  }
  dp[beads[1]][beads[2]][beads[3]][beads[4]][beads[5]][pre][prepre] = cur
  return cur
}

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var N = br.readLine().toInt()

  var beads = Array<Int>(6, {0})

  for(i: Int in 1..N) {
    beads[i] = br.readLine().toInt()
  }

  var answer: Long = dpBeads(beads, 0, 0)
  print(answer)
}