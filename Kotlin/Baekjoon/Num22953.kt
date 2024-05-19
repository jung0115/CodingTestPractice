// 백준 - 도도의 음식 준비(22953)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt() // 요리사의 수
  val K = st.nextToken().toInt() // 만들어야 할 음식의 개수
  val C = st.nextToken().toInt() // 격려해줄 수 있는 횟수

  val cook = Array(N, {0})
  st = StringTokenizer(br.readLine())
  for(i: Int 0..N-1) {
    cook[i] = st.nextToken().toInt()
  }



}