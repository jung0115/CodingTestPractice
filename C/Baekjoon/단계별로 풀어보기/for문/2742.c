//백준 > 단계별로 풀어보기 > for문 > 기찍 N(2742)
#include <stdio.h>
int main(void){
  int N, i;
 
  scanf("%d", &N);
  
  for(i=N; i>=1; i--){
   printf("%d\n", i); 
  }
 
  return 0;
}