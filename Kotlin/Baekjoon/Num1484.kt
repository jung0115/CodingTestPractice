// 백준 - 다이어트(1484)
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val G = br.readLine().toInt()

  val answer = StringBuilder()

  // 현재 몸무게: cur / 기억하는 몸무게: pre
  // G = cur^2 - pre^2 = (cur + pre)(cur - pre)
  // cur + pre <= G && cur - pre <= G

  for(i: Int in 1..G) { // 현재 몸무게 + 기억하는 몸무게 = cur + pre
    // G = (cur + pre)(cur - pre) 이므로 G를 (cur + pre)로 나누면 나누어떨어져야 함
    if(G % i != 0) continue

    // cur, pre 값 찾기
    for(j: Int in 1..i/2) {
      val cur = max(j, i-j) // 현재 몸무게
      val pre = min(j, i-j) // 기억하는 몸무게

      var g = (cur + pre) * (cur - pre)
      if(g == G) {
        answer.append(cur).append("\n")
      }
    }
  }

  // 가능한 몸무게가 없을 경우
  if(answer.length == 0) {
    answer.append("-1")
  }

  print(answer)
}