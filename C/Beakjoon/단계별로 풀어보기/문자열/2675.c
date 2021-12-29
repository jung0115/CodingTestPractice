//백준 > 단계별로 풀어보기 > 문자열 > 문자열 반복(2675)
#include <stdio.h>
 
int main(void){
  int T, R, i, j, k;
  char S[21];
 
  scanf("%d", &T);
 
  for(i=0; i<T; i++){
    scanf("%d", &R);
    scanf("%s", S);
    for(j=0; S[j]!='\0'; j++){
      for(k=0; k<R; k++){
        printf("%c", S[j]);
      }
    }
    printf("\n");
  }
  return 0;
}