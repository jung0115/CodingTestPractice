//백준 > 단계별로 풀어보기 > for문 > 별 찍기 -1(2438)
#include <stdio.h>
int main(void){
  int N, i, j;
 
  scanf("%d", &N);
  
  for(i=1; i<=N; i++){
    for(j=0; j<i; j++)
      printf("*");
    printf("\n");
  }
  return 0;
}