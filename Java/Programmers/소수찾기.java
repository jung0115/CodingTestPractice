// 프로그래머스 - 소수 찾기(Lv.2)
import java.util.ArrayList;
class Solution {
  static ArrayList<Integer> allNums = new ArrayList<>();
  static boolean[] used;
  
  public int solution(String numbers) {
    int answer = 0;
    
    used = new boolean[numbers.length()];
    
    // 가능한 숫자 자리수까지 모든 숫자 조합
    for(int i = 0; i < numbers.length(); i++){
      dfs(numbers, "", i+1);
    }
    
    // 소수인 것 체크
    for(int i = 0; i < allNums.size(); i++){
      if(prime(allNums.get(i))) answer++;              
    }
    
    return answer;
  }
  
  // 가능한 숫자 조합
  static void dfs(String numbers, String numStr, int len) {
    // 숫자 완성
    if(numStr.length() == len){
      int numInt = Integer.parseInt(numStr);
      if(!allNums.contains(numInt)){
        allNums.add(numInt);
      }
    }

    for(int i = 0; i < numbers.length(); i++){
      if(!used[i]){
        used[i] = true;
        dfs(numbers, numStr + numbers.charAt(i), len);
        used[i] = false;
      }
    }
  }
    
  // 소수 판단
  static boolean prime(int num) {
    // 0, 1은 소수가 아님
    if(num < 2) return false;
    
    for(int i = 2; i*i <= num; i++) {
      if(num % i == 0) return false;
    }
    
    return true;
  }
}