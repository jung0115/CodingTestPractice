// 백준 - 자두나무(2240)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  var st = StringTokenizer(br.readLine())

  val T = st.nextToken().toInt() // 떨어지는 자두의 개수
  val W = st.nextToken().toInt() // 자두가 최대로 움직일 횟수

  val plum: Array<Int> = Array(T + 1, {0})
  // [시간][이동 횟수][현재 위치]
  val dp: Array<Array<Array<Int>>> = Array(T + 1, {Array(W + 1, {Array(3, {0})})})
  
  for(i: Int in 1..T) {
    plum[i] = br.readLine().toInt()
  }

  // 첫번째 자두가 1번 나무에서 떨어질 경우 초기값
  if(plum[1] == 1) {
    dp[1][0][1] = 1 // 위치 유지, 자두 1개
    dp[1][1][2] = 0 // 위치 이동, 자두 0개
  }
  // 첫번째 자두가 2번 나무에서 떨어질 경우 초기값
  else {
    dp[1][0][1] = 0 // 위치 유지, 자두 0개
    dp[1][1][2] = 1 // 위치 이동, 자두 1개
  }

  for(t: Int in 2..T) {
    // 1번 자두에서 떨어짐 => 1이면 1, 2이면 0으로
    var one = plum[t] % 2
    // 2번 자두에서 떨어짐 => 1이면 0, 2이면 1으로
    var two = (plum[t] + 1) % 2

    // 이동 횟수 0
    dp[t][0][1] = dp[t - 1][0][1] + one
    dp[t][0][2] = dp[t - 1][0][2] + two

    // 이동 횟수 1 이상
    for(w: Int in 1..W) {
      // 이전에 이동을 w번 했거나, w-1 했었는데 지금 이동 추가 중 더 자두를 많이 받은 경우
      dp[t][w][1] = max(dp[t-1][w][1], dp[t-1][w-1][2]) + one
      dp[t][w][2] = max(dp[t-1][w][2], dp[t-1][w-1][1]) + two
    }
  }

  // 최대값
  var maxPlum = 0
  for(w: Int in 0..W) {
    maxPlum = max(maxPlum, max(dp[T][w][1], dp[T][w][2]))
  }

  print(maxPlum)
}