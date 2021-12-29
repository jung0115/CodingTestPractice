//백준 > 단계별로 풀어보기 > 기본 수학1 > 달팽이는 올라가고 싶다(2869)
#include <stdio.h>
 
int main(void){
  int A, B, V, result, remain;
 
  scanf("%d %d %d", &A, &B, &V);
 
  result=(V-A)/(A-B);
  remain=(V-A)%(A-B);
  result++;
 
  if(remain>0)
    result++;
  
  printf("%d", result);
 
  return 0;
}