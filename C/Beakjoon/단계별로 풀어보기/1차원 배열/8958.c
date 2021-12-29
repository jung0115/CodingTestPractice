//백준 > 단계별로 풀어보기 > 1차원 배열 > OX퀴즈(8958)
#include <stdio.h>
 
int main(void)
{
  int N, allScore, countScore, i, j;
  char answer[81];
 
  scanf("%d", &N); //테스트 케이스 개수
 
  for(i=0; i<N; i++){
    scanf("%s", answer);
    allScore=0;
    countScore=0;
    for(j=0; answer[j]!='\0'; j++){
      if(answer[j]=='O'){
        countScore++;
        allScore += countScore;
      }
      else{
        countScore=0;
      }
    }
    printf("%d\n", allScore);
  }
 
  return 0;
}
