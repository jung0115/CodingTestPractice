//백준 > 단계별로 풀어보기 > 1차원 배열 > 최소, 최대(10818)
#include <stdio.h>
int main(void){
  int N, num[1000000], i, max, min;
 
  scanf("%d", &N);
 
  for(i=0; i<N; i++)
    scanf("%d", &num[i]);
 
  max = num[0];
  min = num[0];
 
  for(i=1; i<N; i++){
    if( max < num[i] )
      max = num[i];
    if( min > num[i] )
      min = num[i];
  }
  
  printf("%d %d", min, max);
  
  return 0;
}