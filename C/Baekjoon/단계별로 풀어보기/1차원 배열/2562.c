//백준 > 단계별로 풀어보기 > 1차원 배열 > 최댓값(2562)
#include <stdio.h>
int main(void){
  int num[1000000], i, max=0;
 
  for(i=0; i<9; i++)
    scanf("%d", &num[i]);
 
  for(i=1; i<9; i++){
    if( num[max] < num[i] )
      max = i;
  }
  
  printf("%d\n%d", num[max], max+1);
 
  return 0;
}