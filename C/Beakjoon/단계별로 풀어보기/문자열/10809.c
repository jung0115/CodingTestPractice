//백준 > 단계별로 풀어보기 > 문자열 > 알파벳 찾기(10809)
#include <stdio.h>
 
int main(void){
  char S[101];
  int i, Check[27]={0}, num;
 
  scanf("%s", S);
 
  for(i=0; S[i]!='\0'; i++){
    num=S[i]-97;
    if(Check[num]==0)
      Check[num]=i+1;
  }
 
  for(i=0; i<26; i++)
    printf("%d ", Check[i]-1);
 
  return 0;
}