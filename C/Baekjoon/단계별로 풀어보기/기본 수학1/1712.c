//백준 > 단계별로 풀어보기 > 기본 수학1 > 손익분기점(1712)
#include <stdio.h>
 
int main(void){
  int A, B, C, result;
 
  scanf("%d %d %d", &A, &B, &C);
 
  if( (B>C) || (A!=0 && B==C) ) //손익분기점이 존재하지 않는 경우
    printf("-1");
  else{
    result=A/(C-B);
    printf("%d", result+1);
  }
 
  return 0;
}