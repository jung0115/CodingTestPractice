//백준 > 단계별로 풀어보기 > while문 > A+B -5(10952)
#include <stdio.h>
int main(void){
  int A, B;
 
  while(1){
    scanf("%d %d", &A, &B);
    if( A == 0 && B == 0)
      break;
    printf("%d\n", A+B);
  }
 
  return 0;
}