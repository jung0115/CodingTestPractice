//백준 > 단계별로 풀어보기 > for문 > 구구단(2739)
#include <stdio.h>
int main(void){
  int N, i;
 
  scanf("%d", &N);
  
  for(i=1; i<=9; i++){
    printf("%d * %d = %d\n", N, i, N*i);
  }
 
  return 0;
}