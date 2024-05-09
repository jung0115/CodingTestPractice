// 백준 - 하늘에서 별똥별이 빗발친다(14658) - 메모리 초과
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

var N = 0
var M = 0
var L = 0
var K = 0
var map: Array<Array<Boolean>> = arrayOf()

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  var maxStar = 0

  N = st.nextToken().toInt() // 가로
  M = st.nextToken().toInt() // 세로
  L = st.nextToken().toInt() // 트램펄린 한 변의 길이
  K = st.nextToken().toInt() // 별똥별의 수

  map = Array(N, {Array(M, {false})}) // 별똥별이 떨어지는 위치를 표시할 지도

  for(i: Int in 0..K-1) {
    st = StringTokenizer(br.readLine())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()

    map[x - 1][y - 1] = true // 별똥별 낙하 위치 표시
  }

  // 트램펄린을 놓을 수 있는 모든 위치 계산
  // 좌상단 좌표 기준으로
  for(i: Int in 0..(N - L)) {
    for(j: Int in 0..(M - L)) {
      // 최대값 구하기
      maxStar = max(maxStar, countStar(i, j))
    }
  }

  print(maxStar)
}
// 튕겨낸 별똥별 개수 세기
fun countStar(x: Int, y: Int): Int {
  var cnt = 0

  // 트램펄린 위로 떨어지는 별똥별
  for(i: Int in x..(x + L - 1)) {
    for(j: Int in y..(y + L - 1)) {
      if(map[i][j]) cnt++
    }
  }

  return cnt
}