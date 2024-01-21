// 프로그래머스 - 호텔 대실(Lv.2)
import java.util.Arrays;

class Solution {
  public int solution(String[][] book_time) {
    int[] times = new int[1440];
    
    for(int i = 0; i < book_time.length; i++) {
      int start, end;
      
      start = Integer.parseInt(book_time[i][0].substring(0, 2)) * 60;
      start += Integer.parseInt(book_time[i][0].substring(3, 5));

      end = Integer.parseInt(book_time[i][1].substring(0, 2)) * 60;
      end += Integer.parseInt(book_time[i][1].substring(3, 5));
      
      for(int j = start; j < end + 10 && j < 1440; j++) {
        times[j]++;
      }
    }
    
    Arrays.sort(times);
    
    return times[1439];
  }
}