// 백준 - 하늘에서 별똥별이 빗발친다(14658)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

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

  for(i: Int in 0..K-1) {
    for(j: Int in 0..K-1) {
      // 두 별똥별을 거치는 가장 큰 사각형 범위
      // 트램펄린 내부에 들어갈 수 있는 개수 체크
      // 좌상단 좌표 
      var startX = min(star[i].x, star[j].x)
      var startY = min(star[i].y, star[j].y)
      // 우하단 좌표
      var finX = startX + L
      var finY = startY + L

      var cnt = 0 // 트램펄린 위에 떨어진 별똥별

      for(k: Int in 0..K-1) {
        // 트램펄린 범위 안에 떨어지는 별똥별 체크
        if(star[k].x >= startX && star[k].x <= finX && star[k].y >= startY && star[k].y <= finY) {
          cnt++
        }
      }

      maxStar = max(maxStar, cnt)
    }
  }

  // 튕겨낸 별똥별을 제외하고 지구에 부딪히는 별똥별의 개수
  print(K - maxStar)
}