// 백준 - 물병(1052)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  var N = st.nextToken().toInt()
  val K = st.nextToken().toInt()

  // N을 2로 계속 나눴을 때, 그 과정에서 나머지 1이 생기는 수 => 최종 물이 채워져있는 물병의 개수
  // 위의 수는 N을 이진수로 바꿨을 때 1의 개수를 세어보는 것과 같음
  var answer = 0

  // K개 이하로 만들어질 때까지 물병 구매
  while(Integer.bitCount(N) > K) {
    N++
    answer++
  }

  print(answer)
}