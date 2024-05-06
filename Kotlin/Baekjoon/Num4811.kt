// 백준 - 알약(4811)
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))

  // 한조각 알약 i개, 반조각 알약 j개가 남았을 때
  var dp: Array<Array<Double>> = Array(31, {Array(31, {0.0})})

  // 반조각짜리만 남아있는 경우 = 반알짜리만 뽑게 되므로 경우의 수 1개
  for(i: Int in 1..30) {
    dp[0][i] = 1.0
  }

  for(i: Int in 1..30) {
    for(j: Int in 0..29) {
      // 아직 반조각 알약이 없는 경우
      if(j == 0) dp[i][j] = dp[i-1][j+1]
      // 반조각 알약이 있는 경우 = 한조각짜리를 먹은 경우 + 반조각짜리를 먹은 경우
      else dp[i][j] = dp[i-1][j+1] + dp[i][j-1]
    }
  }

  var answer = StringBuilder()
  var medicine = br.readLine().toInt()

  while(medicine != 0) {
    answer.append(String.format("%.0f", dp[medicine][0])).append("\n")

    medicine = br.readLine().toInt()
  }

  print(answer)
}