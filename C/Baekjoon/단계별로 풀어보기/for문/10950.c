//백준 > 단계별로 풀어보기 > for문 > A+B -3(10950)
#include <stdio.h>
int main(void){
  int T, A, B, i, sum[10000000];
 
  scanf("%d", &T);
  
  for(i=0; i<T; i++){
    scanf("%d %d", &A, &B);
    sum[i] = A+B;
  }
 
  for(i=0; i<T; i++)
    printf("%d\n", sum[i]);
 
  return 0;
}