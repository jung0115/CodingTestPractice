//백준 > 단계별로 풀어보기 > 기본 수학1 > 분수찾기(1193)
#include <stdio.h>
 
int main(void){
  int X, up, down, sum=0, check=1;
 
  scanf("%d", &X);
 
  while(sum<X){
    sum+=check;
    check++;
  }
  check--;
  sum-=check;
 
  if((check%2)==0){
    up=X-sum;
    down=check-up+1;
  }
  else{
    down=X-sum;
    up=check-down+1;
  }
 
  printf("%d/%d", up, down);
 
  return 0;
}