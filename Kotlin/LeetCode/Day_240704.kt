// LeetCode - 1288. Remove Covered Intervals
class Solution {
  fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    var nums = Array(100001, {false})
    var answer = intervals.size

    // 시작값은 오름차순 정렬, 끝값은 내림치순 정렬
    intervals.sortByDescending { it[1] }
    intervals.sortBy { it[0] }

    for(i: Int in 0..intervals.size - 1) {
      var isCovered = true
      for(n: Int in intervals[i][0]..intervals[i][1]) {
        if(!nums[n]) isCovered = false
        nums[n] = true
      }
      if(isCovered) answer--
    }

    return answer
  }
}