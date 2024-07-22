// 백준 - 도둑(13422)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val T = br.readLine().toInt()

  val answer = StringBuilder()

  for(t: Int in 1..T) {
    // ✅ Input
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt() // 마을에 있는 집의 개수
    val M = st.nextToken().toInt() // 도둑이 돈을 훔칠 연속된 집의 개수
    val K = st.nextToken().toInt() // 방법 장치가 작동하는 최소 돈의 양

    st = StringTokenizer(br.readLine())
    val house = Array(N, {0})
    for(i: Int in 0..N-1) {
      house[i] = st.nextToken().toInt()
    }

    // ✅ Solve
    var start = 0
    var end = -1
    var money = 0

    // 첫 집부터 M개의 집
    while(end < M-1) {
      money += house[++end]
    }

    if(N == M) {
      val cnt = if(money < K) 1 else 0
      answer.append(cnt).append("\n") // ✅ Output
      continue
    }

    var cnt = 0
    while(start < N) {
      if(money < K) cnt++

      money -= house[start]
      start++
      end = (end + 1) % N
      money += house[end]
    }

    answer.append(cnt).append("\n") // ✅ Output
  }

  print(answer) // ✅ Output
}