// 백준 - 점수따먹기(1749)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt()
  val M = st.nextToken().toInt()

  val map = Array(N + 1, {Array(M + 1, {0})})
  for(i: Int in 1..N) {
    st = StringTokenizer(br.readLine())
    for(j: Int in 1..M) {
      map[i][j] = st.nextToken().toInt() + map[i - 1][j] + map[i][j-1] - map[i - 1][j - 1]
    }
  }

  var answer = 200 * 200 * -10000 // 최소값
  // 부분 행렬 가로, 세로 길이
  for(w: Int in 1..N) {
    for(h: Int in 1..M) {

      // 부분 행렬 끝점
      for(rowF: Int in w..N) {
        for(colF: Int in h..M) {
          val cur = map[rowF][colF] - map[rowF - w][colF] - map[rowF][colF - h] + map[rowF - w][colF - h]
          answer = max(answer, cur)
        }
      }
    }
  }

  print(answer)
}
/*
0011
0011
2233
2233

0,0부터 x, y까지의 누적합을 각각 구해둠
3으로 된 부분의 누적합 = 전체 누적 - (0 + 1) - (0 + 2) + 0
*/