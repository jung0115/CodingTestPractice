//백준 > 단계별로 풀어보기 > 기본 수학1 > 부녀회장이 될테야(2775)
#include <stdio.h>
 
int main(void){
  int T, k, n, i, j, people[15][14];
 
  for(i=0; i<15; i++){
    people[0][i]=i+1;
  }
  for(i=1; i<15; i++){
    people[i][0]=1;
    for(j=1; j<14; j++){
      people[i][j]=people[i][j-1]+people[i-1][j];
    }
  }
 
  scanf("%d", &T);
  for(i=0; i<T; i++){
    scanf("%d %d", &k, &n);
    printf("%d\n", people[k][n-1]);
  }
 
  return 0;
}