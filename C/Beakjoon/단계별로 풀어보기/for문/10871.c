//백준 > 단계별로 풀어보기 > for문 > X보다 작은 수(10871)
#include <stdio.h>
int main(void){
  int N, X, A, M[1000000], cnt = 0, i;
 
  scanf("%d %d", &N, &X);
  
  for(i=0; i<N; i++){
    scanf("%d", &A);
    if( A < X ){
      M[cnt] = A;
      cnt++;
    }
  }
 
  for(i=0; i<cnt; i++)
    printf("%d ", M[i]);
 
  return 0;
}