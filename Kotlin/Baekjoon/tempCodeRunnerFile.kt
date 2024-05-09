// 백준 - 하늘에서 별똥별이 빗발친다(14658)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

data class Star(
  var x: Int,
  var y: Int
)

var N = 0
var M = 0
var L = 0
var K = 0
var star: Array<Star> = arrayOf()

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  var maxStar = 0 // 떨어지는 별똥별 최대값

  N = st.nextToken().toInt() // 가로
  M = st.nextToken().toInt() // 세로
  L = st.nextToken().toInt() // 트램펄린 한 변의 길이
  K = st.nextToken().toInt() // 별똥별의 수

  star = Array(K, {Star(0, 0)}) // 별똥별이 떨어지는 위치

  for(i: Int in 0..K-1) {
    st = StringTokenizer(br.readLine())
    star[i].x = st.nextToken().toInt()
    star[i].y = st.nextToken().toInt()
  }

  // x좌표 기준으로 정렬
  star.sortBy{ it.x }

  // 트램펄린 좌상단 좌표를 잡고
  // 트램펄린 내부에 들어갈 수 있는 개수 체크
  for(i: Int in star[0].x..N-L) {
    for(j: Int in 0..M-L) {
      // 좌상단 좌표: (i, j)
      // 우하단 좌표
      var finX = i + L - 1
      var finY = j + L - 1

      var cnt = 0 //  트램펄린 위에 떨어진 별똥별

      for(k: Int in 0..K-1) {
        // x좌표의 끝을 넘어간 경우 체크 멈추기
        if(star[k].x > finX) break

        // x좌표는 트램펄린 내에 있음
        // y좌표도 트램펄린 내에 있을 경우 체크
        if(star[k].y >= j && star[k].y <= finY) cnt++
      }
      maxStar = max(maxStar, cnt)
    }
  }

  // 튕겨낸 별똥별을 제외하고 지구에 부딪히는 별똥별의 개수
  print(K - maxStar)
}