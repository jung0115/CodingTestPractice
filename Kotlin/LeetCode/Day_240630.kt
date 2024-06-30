class Solution {
  fun numWays(s: String): Int {
    val oneCount = s.count { it == '1' } // 1의 개수

    // 3개의 string으로 나눴을 때 1의 개수가 동일할 수 없는 경우
    if(oneCount % 3 != 0) return 0

    var answer: Long = 1L

    // 1이 없는 경우
    if(oneCount == 0) {
      // 나머지를 3개로 나누기
      // 갈라질 수 있는 위치 중 2군데 고르기
      // ex) 0|0|0|0|0 -> |이 있는 위치 4곳 중 2개를 골라서 그 기준으로 나누기
      // (length-1)C2 = (length-1)! / ((length-3)!2!) = (length-1)(length-2) / 2
      answer = (s.length - 1).toLong() * (s.length - 2).toLong() / 2L
    }

    else {
      // 나머지는 1을 기준으로 잘라주고
      // 1의 개수가 똑같이 나눠지고
      // 0들은 앞 또는 뒤에 붙는 경우의 수 -> nC1
      val subString = s.split("1")
      val step = oneCount / 3

      for(i: Int in step..subString.size - 2 step(step)) {
        if(subString[i].length != 0) {
          answer *= (subString[i].length + 1)
        }
      }
    }

    // answer가 너무 크면 10^9 + 7로 나눈 나머지를
    answer %= 1000000007

    return answer.toInt()
  }
}