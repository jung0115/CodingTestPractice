// LeetCode - 1605. Find Valid Matrix Given Row and Column Sums
import kotlin.math.min

class Solution {
  fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
    var answer = Array(rowSum.size, {IntArray(colSum.size, {0})})

    for(i: Int in 0..rowSum.size-1){
      for(j: Int in 0..colSum.size-1) {
        var min = min(rowSum[i], colSum[j])
        answer[i][j] = min

        rowSum[i] -= min
        colSum[j] -= min
      }
    }

    return answer
  }
}