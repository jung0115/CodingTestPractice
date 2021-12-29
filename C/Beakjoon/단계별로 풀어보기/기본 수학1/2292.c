//백준 > 단계별로 풀어보기 > 기본 수학1 > 벌집(2292)
#include <stdio.h>
 
int main(void){
  int N, sum=1,cnt=1;
 
  scanf("%d", &N);
 
  while(sum<N){
    sum=sum+cnt*6;
    cnt++;
  }
 
  printf("%d", cnt);
 
  return 0;
}