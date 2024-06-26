// LeetCode - 11. Container With Most Water / Time Limit Exceeded
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxArea(height: IntArray): Int {
    var answer: Int = 0
    
    for(i: Int in 0..(height.size - 2)) {
      for(j: Int in (i + 1)..(height.size - 1)) {
        val area: Int = (j-i) * min(height[i], height[j])
        answer = max(answer, area)
      }
    }

    return answer
  }
}