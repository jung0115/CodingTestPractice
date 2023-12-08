// 프로그래머스 - 카펫(Lv.2)
class Solution {
  public int[] solution(int brown, int yellow) {
    int width = 3;
    int area = brown + yellow;
    
    int[] answer = new int[2];
    
    while((width * 3) <= area) {
      if(area % width == 0) {
        int height = area / width;
        int y = (width - 2) * (height - 2);
        // 카펫의 가로, 세로가 맞을 경우
        if(y == yellow && (area - y) == brown) {
          // 더 큰 값이 가로
          answer[0] = Math.max(width, height);
          answer[1] = Math.min(width, height);
          break;
        }
      }
      width++;
    }
    
    return answer;
  }
}
/*
width * height = brown + yellow
yellow = (width - 2) * (height - 2)
brown = width * height - yellow

width >= height >= 3
*/