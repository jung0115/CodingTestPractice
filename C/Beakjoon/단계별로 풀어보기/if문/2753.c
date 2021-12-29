//백준 > 단계별로 풀어보기 > if문 > 윤년(2753)
#include <stdio.h>
int main(void){
  int year;
  scanf("%d", &year);
  
  if(((year%4) == 0 && (year%100) != 0) || (year%400) == 0)
	  printf("1");
  else
	  printf("0");
   
  return 0;
}