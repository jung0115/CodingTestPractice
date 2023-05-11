//백준 > 단계별로 풀어보기 > for문 > A+B -8(11022)
#include <stdio.h>
int main(void){
  int T, A[1000000], B[1000000], i;
 
  scanf("%d", &T);
  
  for(i=0; i<T; i++){
    scanf("%d %d", &A[i], &B[i]);
  }
 
  for(i=0; i<T; i++)
    printf("Case #%d: %d + %d = %d\n", i+1, A[i], B[i], A[i] + B[i]);
 
  return 0;
}