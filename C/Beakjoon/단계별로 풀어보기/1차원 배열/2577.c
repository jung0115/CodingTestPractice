//백준 > 단계별로 풀어보기 > 1차원 배열 > 숫자의 개수(2577)
#include <stdio.h>
int main(void){
  int A, B, C, mul, num[10] = {0}, n, i;
 
  scanf("%d %d %d", &A, &B, &C);
 
  mul = A * B * C;
 
  while(1){
    n = mul%10;
    num[n]++;
    mul/=10;
    if(mul == 0)
      break;
  }
 
  for(i=0; i<10; i++){
    printf("%d\n", num[i]);
  }
  return 0;
}