//백준 > 단계별로 풀어보기 > 기본 수학1 > 설탕 배달(2839)
#include <stdio.h>
 
int main(void){
  int N, five, three, remain;
 
  scanf("%d", &N);
 
  five=N/5;
  remain=N%5;
  three=remain/3;
  remain=remain%3;
 
  if(remain==0)
    printf("%d", five+three);
  else if(remain==1&&N>=6){
    five--;
    three+=2;
    printf("%d", five+three);
  }
  else if(remain==2&&N>=12){
    five-=2;
    three+=4;
    printf("%d", five+three);
  }
  else
    printf("-1");
 
  return 0;
}