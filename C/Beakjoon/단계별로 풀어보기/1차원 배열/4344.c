//백준 > 단계별로 풀어보기 > 1차원 배열 > 평균은 넘겠지(4344)
#include <stdio.h>
 
int main(void)
{
  int C, N, score[1000], i, j, sum, cnt;
  double average, percent;
 
  scanf("%d", &C);
 
  for(i=0; i<C; i++){
    scanf("%d", &N);
    sum=0;
    cnt=0;
    for(j=0; j<N; j++){
      scanf("%d", &score[j]);
      sum += score[j];
    }
    average = (sum*1.0)/(N*1.0);
    for(j=0; j<N; j++){
      if(score[j] > average)
        cnt++;
    }
    percent=(cnt*1.0)/(N*1.0)*100.0;
    printf("%.3lf%%\n", percent);
  }
  return 0;
}