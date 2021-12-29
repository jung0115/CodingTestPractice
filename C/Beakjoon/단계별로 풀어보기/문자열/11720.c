//백준 > 단계별로 풀어보기 > 문자열 > 숫자의 합(11720)
#include <stdio.h>
 
int main(void){
  char num[101];
  int sum=0, i, n;
 
  scanf("%d", &n);
  scanf("%s", num);
 
  for(i=0; i<n; i++){
    sum+=(num[i]-48);
  }
 
  printf("%d", sum);
 
  return 0;
}