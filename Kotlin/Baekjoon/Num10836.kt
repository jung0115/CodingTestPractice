// 백준 - 여왕벌(10836)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val M = st.nextToken().toInt()
  var N = st.nextToken().toInt()

  val size = Array(M * 2 - 1, {1})

  while(N-- > 0) {
    st = StringTokenizer(br.readLine())

    // 0은 더해도 의미 없으므로 버리기
    var grow = st.nextToken().toInt() 
    var idx = grow
    // 1, 2 누적
    for(j: Int in 1..2) {
      grow = st.nextToken().toInt()
      
      // 왼쪽 열, 위쪽 행 성장 체크
      while(grow-- > 0) {
        size[idx] += j
        idx++
      }
    }
  }

  val answer = StringBuilder()
  for(i: Int in M-1 downTo 0 step(1)) {
    // 제일 왼쪽 열
    answer.append(size[i]).append(" ")
    // 제일 왼쪽 열을 제외하면 자신의 위와 동일한 값
    for(j: Int in M..M*2-2) {
      answer.append(size[j]).append(" ")
    }
    answer.append("\n")
  }

  print(answer)
}