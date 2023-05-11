//백준 > 단계별로 풀어보기 > 문자열 > 단어의 개수(1152)
#include <stdio.h>
 
int main(void){
  char S[1000001];
  int i, cnt=0;
 
  scanf("%[^\n]s", S); //공백 포함해서 입력 받음
 
  for(i=0; S[i]!='\0'; i++){
    if(S[i]==' '&&S[i+1]!='\0')
      cnt++;
  }
 
  if(S[0]!=' ')
    cnt++;
 
  printf("%d", cnt);
 
  return 0;
}