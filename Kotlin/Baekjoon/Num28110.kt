// 백준 - 마지막 문제(28110)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))

  val N = br.readLine().toInt()

  val st = StringTokenizer(br.readLine())
  val levels = Array<Int>(N){0}
  
  for(i: Int in 0..N-1) {
    levels[i] = st.nextToken().toInt()
  }

  val sortLevels = levels.sorted()

  var answer = -1
  var maxGap = 0 

  for(i: Int in 1..N-1) {
    val gap = (sortLevels[i] - sortLevels[i - 1]) / 2

    if(gap > maxGap) {
      answer = sortLevels[i - 1] + gap
      maxGap = gap
    }
  }

  print(answer)
}