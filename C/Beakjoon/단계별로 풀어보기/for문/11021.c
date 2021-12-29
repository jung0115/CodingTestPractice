//백준 > 단계별로 풀어보기 > for문 > A+B -7(11021)
#include <stdio.h>
int main(void){
  int T, A, B, i, sum[1000000];
 
  scanf("%d", &T);
  
  for(i=0; i<T; i++){
    scanf("%d %d", &A, &B);
    sum[i] = A+B;
  }
 
  for(i=0; i<T; i++)
    printf("Case #%d: %d\n", i+1, sum[i]);
 
  return 0;
}