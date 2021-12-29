//백준 > 단계별로 풀어보기 > 기본 수학1 > Fly me to the Alpha Centauri(1011)
#include <stdio.h>
#include <math.h>
 
int main(void){
  int T, i;
  long long x, y, num, lenth;
 
  scanf("%d", &T);
 
  for(i=0; i<T; i++){
    scanf("%lld %lld", &x, &y);
    lenth=y-x;
    num=(int)sqrt(lenth);
 
    if(lenth==num*num)
      printf("%lld\n", (2*num)-1);
    else if((num*num)<lenth && lenth<=(num*num)+num)
      printf("%lld\n", 2*num);
    else
      printf("%lld\n", (2*num)+1);
  }
 
  return 0;
}