// 프로그래머스 - 모음 사전(Lv.2)
import java.util.ArrayList;
import java.util.List;

class Solution {
  static String[] alpha = {"A", "E", "I", "O", "U"};
  static List<String> words;
  public int solution(String word) {
    int answer = 0;
    words = new ArrayList<>();
    dfs("");
    
    for(int i = 1; i < words.size(); i++) {
      if(words.get(i).equals(word)) {
        answer = i;
        break;
      }
    }

    
    return answer;
  }
  static void dfs(String w) {
    words.add(w);
    if(w.length() == 5) return;
    
    for(int i = 0; i < 5; i++) {
      dfs(w + alpha[i]);
    }
  }
}