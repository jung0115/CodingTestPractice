// LeetCode - 11. Container With Most Water
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxArea(height: IntArray): Int {
    var answer: Int = 0
    // 가장 바깥쪽 기둥부터 탐색
    var left = 0
    var right = height.size - 1

    while(left < right) {
      val area: Int = (right - left) * min(height[left], height[right])
      answer = max(answer, area)

      // 왼쪽, 오른쪽 중 더 짧은 쪽을 안쪽으로 이동
      if(height[left] > height[right]) {
        right--
      }
      else {
        left++
      }
    }

    return answer
  }
}