// 프로그래머스 - 뒤에 있는 큰 수 찾기(Lv.2) - (91.3 / 100.0) 실패
class Solution {
  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    
    for(int i = 0; i < numbers.length; i++) {
      // 앞이랑 같은 수라면 뒷 큰수도 같음
      if(i > 0 && numbers[i] == numbers[i-1])
        answer[i] = answer[i-1];
      
      // 앞의 수보다 작고, 앞의 수의 뒷 큰수가 존재한다면 뒷 큰수가 같음
      else if(i > 0 && numbers[i] < numbers[i-1] && numbers[i-1] == -1)
        answer[i] = answer[i-1];
      
      // 앞의 수보다 크고, 앞의 수의 뒷 큰수가 현재 수가 아니라면 뒷 큰수가 같음
      else if(i > 0 && numbers[i] > numbers[i-1] && numbers[i] != answer[i-1])
        answer[i] = answer[i-1];
      
      else
        answer[i] = findBigNumber(numbers, i);
    }
    
    return answer;
  }
  
  // 뒷 큰수 찾기
  static int findBigNumber(int[] numbers, int index) {
    int num = -1;
    
    for(int i = index + 1; i < numbers.length; i++) {
      if(numbers[index] < numbers[i]) {
        num = numbers[i];
        break;
      }
    }
    
    return num;
  }
}