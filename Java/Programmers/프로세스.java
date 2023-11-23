// 프로그래머스 - 프로세스(Lv.2)
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
  public int solution(int[] priorities, int location) {
    Queue<Process> queue = new LinkedList<>();
    int answer = 0;
    
    // 큐 세팅
    for(int i = 0; i < priorities.length; i++) {
        queue.add(new Process(i, priorities[i]));
    }
    
    // 우선순위가 가장 높은 값을 확인하기 위해
    Arrays.sort(priorities);
    int maxIndex = priorities.length - 1;
    
    while (!queue.isEmpty()) {
      Process process = queue.poll();
      // 우선순위가 더 높은 값이 남아있는지 확인
      // 우선순위가 가장 높은 값인 경우
      if(process.priority == priorities[maxIndex]) {
        answer++;
        // 찾고 있는 프로세스인 경우
        if(process.firstIndex == location) {
            break;
        }
        // 찾고 있는 프로세스가 아닌 경우
        else {
          maxIndex--;
        }
      }
      // 우선순위가 높은 값이 아직 남아있는 경우
      else {
        queue.add(process);
      }
    }
    
    return answer;
  }

  class Process {
    int firstIndex; // 최초 index
    int priority;  // 우선순위

    public Process(int firstIndex, int priority){
      this.firstIndex = firstIndex;
      this.priority = priority;
    }
  }
}

/*
우선순위 큐를 쓰면 그냥 우선순위 높은 거부터 탐색됨
우선순위가 높은 것부터 탐색하되, 뒤에 우선순위 높은 게 있으면 맨 뒤로 다시 push 해줘야 함
*/