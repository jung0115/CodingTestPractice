//백준 > 단계별로 풀어보기 > 기본 수학1 > ACM 호텔(10250)
#include <stdio.h>
 
int main(void){
  int T, H, W, N, i, up, down, result;
 
  scanf("%d", &T);
 
  for(i=0; i<T; i++){
    scanf("%d %d %d", &H, &W, &N);
    down=(N/H)+1;
    up=(N%H);
    if(up==0){
      down--;
      up=H;
    }
    result=(up*100)+down;
    printf("%d\n", result);
  }
 
  return 0;
}