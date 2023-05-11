//백준 > 단계별로 풀어보기 > while문 > 더하기 사이클(1110)
#include <stdio.h>
int main(void){
  int N, M, cnt=0, tmp;
 
  scanf("%d", &N);
 
  M = N;
 
  do{
    tmp = (M/10) + (M%10);
    M = ((M%10)*10) + (tmp%10);
    cnt++;
  } while( N != M );
 
  printf("%d", cnt);
 
  return 0;
}