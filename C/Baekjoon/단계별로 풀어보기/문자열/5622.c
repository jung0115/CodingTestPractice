//백준 > 단계별로 풀어보기 > 문자열 > 다이얼(5622)
#include <stdio.h>
 
int main(void){
  char number[16];
  int alphabet[26]={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9}, i, time=0, num;
 
  scanf("%s", number);
 
  for(i=0; number[i]!='\0'; i++){
    num=number[i]-'A';
    time+=(1+alphabet[num]);
  }
 
  printf("%d", time);
 
  return 0;
}