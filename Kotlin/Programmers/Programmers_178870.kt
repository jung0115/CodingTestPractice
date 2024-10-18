// 프로그래머스 - 연속된 부분 수열의 합(Lv.2)

class Solution {
  data class Answer(
    var start: Int,
    var end: Int,
    var length: Int,
  )
  fun solution(sequence: IntArray, k: Int): IntArray {
    var result = mutableListOf<Answer>()
    
    var sum = 0
    var index = 0
    for(i: Int in 0..sequence.size - 1) {
      sum += sequence[i]
      
      while(sum > k) {
        sum -= sequence[index++]
      }
      
      if(sum == k) {
        result.add(
          Answer(
            start = index,
            end = i,
            length = i - index + 1
          )
        )
      }
    }
    
    result.sortWith(
      compareBy<Answer> {
        it.length
      }.thenBy {
        it.start
      }
    )
    
    var answer: IntArray = intArrayOf(result[0].start, result[0].end)
    
    return answer
  }
}