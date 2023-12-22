// 프로그래머스 - 모음 사전(Lv.2) - fail
class Solution {
  public int solution(String word) {
    char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    
    // 자리수마다 존재 가능한 갯수
    int[] cnt = new int[5];
    cnt[0] = 1;
    int temp = 1;
    for(int i = 1; i < 5; i++) {
      temp *= 5;
      cnt[i] = cnt[i-1] + temp;
    }
    
    int answer = 0;
    for(int i = word.length() - 1; i >= 0; i--) {
      System.out.print(word.charAt(i) + " ");
      for(int j = 0; j < 5; j++) {
        if(word.charAt(i) == alpha[j]) {
          answer += j * cnt[4 - i];
          System.out.println(i + " " + j);
        }
      }
    }
    
    return answer;
  }
}
/*
A로 시작하는 글자: 1 + 5 + 25 + 125 + 625 개
I로 시작하는 글자: 1 + 5 + 25 + 125 + 625 개
...
*/