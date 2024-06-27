// LeetCode - 34. Find First and Last Position of Element in Sorted Array
class Solution {
  fun searchRange(nums: IntArray, target: Int): IntArray {
    var answer = IntArray(2) { -1 }
    for(i: Int in 0..nums.size - 1) {
      if(nums[i] == target) {
        answer[0] = i
        break
      }
    }

    for(i: Int in nums.size - 1 downTo answer[0]+1 step 1) {
      if(nums[i] == target) {
        answer[1] = i
        break
      }
    }

    if(answer[1] == -1 && answer[0] != -1) answer[1] = answer[0]

    return answer
  }
}