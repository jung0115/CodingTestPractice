// 프로그래머스 - 베스트앨범(Lv.2) - 46.7 / 100.0
import java.util.*;

class Solution {
  public List<Integer> solution(String[] genres, int[] plays) {
    HashMap<String, Integer[]> musics = new HashMap<>();
    HashMap<String, Integer> playSum = new HashMap<>();
    
    for(int i = 0; i < genres.length; i++) {
      // 처음 나온 장르라면
      if(musics.get(genres[i]) == null) {
        Integer[] play = new Integer[2];
        play[0] = i;
        play[1] = -1;
        musics.put(genres[i], play);
        playSum.put(genres[i], plays[i]);
      }
      else {
          Integer[] play = musics.get(genres[i]);
          if(play[1] == -1) {
            if(plays[play[0]] < plays[i]) {
                play[1] = play[0];
                play[0] = i;
            }
            else
                play[1] = i;
            
            playSum.put(genres[i], playSum.get(genres[i]) + plays[i]);
          }
          else if(plays[play[0]] < plays[i]) {
            play[1] = play[0];
            play[0] = i;
            
            playSum.put(genres[i], playSum.get(genres[i]) - plays[play[1]] + plays[i]);
          }
          else if(plays[play[1]] < plays[i]) {
            play[1] = i;
            
            playSum.put(genres[i], playSum.get(genres[i]) - plays[play[1]] + plays[i]);
          }
          
          musics.put(genres[i], play);
        }
    }
    
    // 장르별 재생 횟수 내림차순 정렬
    List<String> keySet = new ArrayList<>(playSum.keySet());
    keySet.sort((o1, o2) -> playSum.get(o2).compareTo(playSum.get(o1)));
    
    List<Integer> answer = new ArrayList<>();
    
    for(int i = 0; i < musics.size(); i++) {
      Integer[] play = musics.get(keySet.get(i));
      answer.add(play[0]);
      if(play[1] != -1) answer.add(play[1]);
    }
    
    return answer;
  }
}