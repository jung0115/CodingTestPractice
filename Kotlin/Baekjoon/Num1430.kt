// 백준 - 공격(1430)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue
import kotlin.math.pow
import kotlin.math.sqrt

data class Position (
  val x: Int,
  val y: Int,
  val moveCount: Int
)

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val N = st.nextToken().toInt() // 탑의 개수
  val R = st.nextToken().toInt() // 사정 거리
  val D = st.nextToken().toInt() // 초기 에너지
  val X = st.nextToken().toInt() // 적의 X 좌표
  val Y = st.nextToken().toInt() // 적의 Y 좌표

  val tops = Array(N, {Array(2, {0})})
  for(i: Int in 0..N-1) {
    st = StringTokenizer(br.readLine())
    tops[i][0] = st.nextToken().toInt() // 탑의 X 좌표
    tops[i][1] = st.nextToken().toInt() // 탑의 Y 좌표
  }

  var queue = LinkedList<Position>() as Queue<Position>
  var visited = Array(N, {false})

  var answer: Double = 0.0
  queue.offer(Position(X, Y, 0))

  while(!queue.isEmpty()) {
    val cur = queue.poll()

    for(i: Int in 0..N-1) {
      // 탑과의 거리
      val dis: Double = sqrt(((tops[i][0] - cur.x) * (tops[i][0] - cur.x) + (tops[i][1] - cur.y) * (tops[i][1] - cur.y)).toDouble())
      if(!visited[i] && dis <= R) {
        var energy: Double = D.toDouble()
        for(i: Int in 1..cur.moveCount) {
          energy /= 2.0
        }
        answer += energy

        visited[i] = true
        queue.offer(Position(tops[i][0], tops[i][1], cur.moveCount + 1))
      }
    }
  }

  print(answer)
}