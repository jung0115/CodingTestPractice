// 프로그래머스 - 베스트앨범(Lv.2)
import java.util.*;

class Solution {
  static class Music{
    int play;
    int idx;

    public Music(int play, int idx) {
      this.play = play;
      this.idx = idx;
    }
  }
  
  public Integer[] solution(String[] genres, int[] plays) {
    HashMap<String, Integer> playSum = new HashMap<>();
    
    // 장르별 재생횟수
    for(int i = 0; i < genres.length; i++){
      playSum.put(genres[i], playSum.getOrDefault(genres[i], 0) + plays[i]);
    }

    // 장르별 재생 횟수 내림차순 정렬
    List<String> genresOrdered = new ArrayList<>(playSum.keySet());
    genresOrdered.sort((o1, o2) -> playSum.get(o2).compareTo(playSum.get(o1)));

    // 재생 횟수가 많은 장르부터 노래 선택
    ArrayList<Integer> result = new ArrayList<>();
    
    for(String genre : genresOrdered){
      ArrayList<Music> list = new ArrayList<>();
      
      // 해당 장르의 노래를 배열에 정리
      for(int i = 0; i < genres.length; i++){
        if(genres[i].equals(genre)){
          list.add(new Music(plays[i], i));
        }
      }
      
      // 노래 재생 횟수 기준으로 내림차순 정렬
      Collections.sort(list, (o1, o2) -> o2.play - o1.play);
      
      // 가장 재생 횟수가 높은 한 곡은 무조건 수록
      result.add(list.get(0).idx); 
      // 만약 2곡 이상이라면 한 곡 더 추가
      if(list.size() != 1) {
        result.add(list.get(1).idx);
      }
    }
    
    Integer[] answer = result.toArray(new Integer[result.size()]);
    
    return answer;
  }
}