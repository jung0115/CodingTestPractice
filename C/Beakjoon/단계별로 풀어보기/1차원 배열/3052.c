//백준 > 단계별로 풀어보기 > 1차원 배열 > 나머지(3052)
#include <stdio.h>
int main(void){
  int num[10], check[42]={0}, i, cnt=0;
 
  for(i=0; i<10; i++)
    scanf("%d", &num[i]);
  
  for(i=0; i<10; i++){
    check[num[i]%42]++;
  }
 
  for(i=0; i<42; i++){
    if(check[i] > 0)
      cnt++;
  }
 
  printf("%d", cnt);
 
  return 0;
}