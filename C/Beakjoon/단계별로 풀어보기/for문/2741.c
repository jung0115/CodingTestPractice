//백준 > 단계별로 풀어보기 > for문 > N 찍기(2741)
#include <stdio.h>
int main(void){
  int N, i;
 
  scanf("%d", &N);
  
  for(i=1; i<=N; i++){
   printf("%d\n", i); 
  }
 
  return 0;
}