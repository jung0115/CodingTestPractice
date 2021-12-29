//백준 > 단계별로 풀어보기 > if문 > 알람 시계(2884)
#include <stdio.h>
int main(void){
  int H, M;
 
  scanf("%d %d", &H, &M);
 
  if(M < 45){
    int sample;
    sample = 45 - M;
    M = 60 - sample;
    if(H == 0)
      H = 23;
    else
      H--;
  }
  else if(M == 45)
    M = 0;
  else
    M -= 45;
 
  printf("%d %d", H, M);
 
  return 0;
}
