// 프로그래머스 - 디스크 컨트롤러(Lv.2)
import java.util.PriorityQueue

class Solution {
  fun solution(jobs: Array<IntArray>): Int {
    var answer = 0
    var sortedJobs = jobs.map { it[0] to it[1] }.sortedBy { it.first }
    val queue: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
    var time = 0
    var clearCnt = 0
    
    while(clearCnt < jobs.size) {
      val wating = sortedJobs.takeWhile { it.first <= time }
      queue.addAll(wating)
      sortedJobs = sortedJobs.drop(wating.size)
      
      if(queue.isEmpty()) {
        time = sortedJobs.first().first
      }
      else {
        val work = queue.poll()
        time += work.second
        answer += (time - work.first) // 요청 전 시간 빼줌
        
        clearCnt++
      }
    }
    
    return answer / jobs.size
  }
}