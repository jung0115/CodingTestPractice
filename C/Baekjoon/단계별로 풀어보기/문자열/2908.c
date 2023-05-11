//백준 > 단계별로 풀어보기 > 문자열 > 상수(2908)
#include <stdio.h>
 
int main(void){
  char num1[4], num2[4];
  int i, backNum1=0, backNum2=0, check;
 
  scanf("%s %s", num1, num2);
 
  for(i=2; i>=0; i--){
    check=num1[i]-'0';
    backNum1=(backNum1*10)+check;
 
    check=num2[i]-'0';
    backNum2=(backNum2*10)+check;
  }
 
  if(backNum1>=backNum2)
    printf("%d", backNum1);
  else
    printf("%d", backNum2);
 
  return 0;
}