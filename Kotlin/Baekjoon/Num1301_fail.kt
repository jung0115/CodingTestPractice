// 백준 - 비즈 공예(1301) - 실패
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var N = br.readLine().toInt()

  var beads = Array(11, {0})
  var max = 0
  var min = 35

  for(i: Int in 0..N-1) {
    var input = br.readLine().toInt()

    max = max(max, input)
    min = min(min, input)

    beads[input]++
  }

  // 구슬을 다 쓸 수 없는 경우 = 목걸이 조합 불가
  if(max - min > 1) {
    print(0)
    return
  }

  // 구슬의 개수가 모두 동일한 경우 = N!가지 경우의 수
  if(max == min) {
    var answer = 1
    for(i: Int in 2..N) {
      answer *= i
    }
    print(answer)
  }

  // 구슬의 개수가 다른 경우 => 구슬이 3종류일 때, 그 이상일 때를 분리
  // = N!가지에서 겹치는 구슬 가지수!
  // 예) 1,2번 구슬은 1개씩, 4,5,6번 구슬은 2개씩 있을 경우
  // 1개씩인 구슬 2가지, 2개씩인 구슬 3가지
  // 2! * 3!
  if(max != min) {
    var answer = 1
    for(i: Int in 1..10) {
      if(beads[i] > 1) {
        for(j: Int in 2..beads[i]) {
          answer *= j
        }
      }
    }
    print(answer)
  }
}