// 백준 - 도서관(1461)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt() // 책의 개수
  val M = st.nextToken().toInt() // 한 번에 들 수 있는 책의 개수

  var books = mutableListOf<Int>()

  st = StringTokenizer(br.readLine())
  for(i: Int in 1..N) {
    books.add(st.nextToken().toInt())
  }

  // 책 위치 오름차순
  books.sort()

  var answer = 0

  // 음수
  // M개씩
  var idx = books.count { it < 0 }
  for(i: Int in 0..idx-1 step(M)) {
    answer += books[i] * -1 * 2
  }

  // 양수
  for(i: Int in N-1 downTo idx step(M)) {
    answer += books[i] * 2
  }

  // 마지막에는 안 돌아와도 됨
  // 최대한 멀리있을 때
  answer -= max(books[0] * -1, books[N-1])

  print(answer)
}