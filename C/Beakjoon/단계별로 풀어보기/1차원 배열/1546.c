//백준 > 단계별로 풀어보기 > 1차원 배열 > 평균(1546)
#include <stdio.h>
 
int main(void)
{
  int N, score[1000], max=0, i;
  double changeSum=0.0;
 
  scanf("%d", &N);
 
  for(i=0; i<N; i++){ //최대값 탐색
    scanf("%d", &score[i]);
    if(score[i] > max)
      max=score[i];
  }
 
  for(i=0; i<N; i++){
    changeSum += ((score[i]*1.0)/(max*1.0))*100.0;
  }
 
  printf("%lf", changeSum/(N*1.0));
 
  return 0;
}