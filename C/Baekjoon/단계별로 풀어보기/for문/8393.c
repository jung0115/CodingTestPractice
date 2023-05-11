//백준 > 단계별로 풀어보기 > for문 > 합(8393)
#include <stdio.h>
int main(void){
  int n, sum=0, i;
 
  scanf("%d", &n);
  
  for(i=1; i<=n; i++){
    sum+=i;
  }
 
  printf("%d", sum);
 
  return 0;
}