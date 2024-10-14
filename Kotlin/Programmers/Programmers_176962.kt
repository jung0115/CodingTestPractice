// 프로그래머스 - 과제 진행하기(Lv.2)
import java.util.*

class Solution {

  data class Task(val name: String, val start: Int, var playtime: Int)

  fun solution(plans: Array<Array<String>>): Array<String> {
    val answer = mutableListOf<String>()
    val pq = PriorityQueue<Task> { o1, o2 -> o1.start - o2.start }

    // 시간을 분 단위로 변환하여 저장
    for (plan in plans) {
      val (name, timeStr, playtimeStr) = plan
      val (h, m) = timeStr.split(":").map { it.toInt() }
      val start = h * 60 + m
      val playtime = playtimeStr.toInt()
      pq.add(Task(name, start, playtime))
    }

    val remainingTasks = Stack<Task>()

    while (pq.isNotEmpty()) {
      val currentTask = pq.poll()
      var currentTime = currentTask.start

      if (pq.isNotEmpty()) {
        val nextTask = pq.peek()

        // 현재 과제를 끝내고도 시간이 남는 경우
        if (currentTime + currentTask.playtime < nextTask.start) {
          answer.add(currentTask.name)
          currentTime += currentTask.playtime

          // 잠시 멈춘 과제들을 처리
          while (remainingTasks.isNotEmpty()) {
            val rem = remainingTasks.pop()
            if (currentTime + rem.playtime <= nextTask.start) {
              currentTime += rem.playtime
              answer.add(rem.name)
            } else {
              rem.playtime -= nextTask.start - currentTime
              remainingTasks.push(rem)
              break
            }
          }
        } 
        // 현재 과제를 끝내는 시간이 다음 과제 시작 시간과 같은 경우
        else if (currentTime + currentTask.playtime == nextTask.start) {
          answer.add(currentTask.name)
        } 
        // 현재 과제를 끝내지 못하는 경우
        else {
          currentTask.playtime -= nextTask.start - currentTime
          remainingTasks.push(currentTask)
        }
      } 
      // 더 이상 새로운 과제가 없는 경우, 남은 과제 처리
      else {
        answer.add(currentTask.name)
        while (remainingTasks.isNotEmpty()) {
          answer.add(remainingTasks.pop().name)
        }
      }
    }

    return answer.toTypedArray() // Array<String>으로 변환하여 반환
  }
}