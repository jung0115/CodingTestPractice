//백준 > 단계별로 풀어보기 > 문자열 > 단어 공부(1157)
#include <stdio.h>
 
int main(void){
  char S[1000001];
  int check[26]={0}, i, num, max=0, sameCount=0;
 
  scanf("%s", S);
  
  for(i=0; S[i]!='\0'; i++){
    if('a'<=S[i] && S[i]<='z') //소문자인 경우
      num=S[i]-'a';
    else if('A'<=S[i] && S[i]<='Z') //대문자인 경우
      num=S[i]-'A';
    check[num]++;
  }
 
  for(i=1; i<26; i++){
    if(check[max]<check[i]){
      max=i;
      sameCount=0;
    }
    else if(check[max]==check[i])
      sameCount++;
  }
 
  if(sameCount>0) //가장 많이 사용된 알파벳이 여러개 존재하는 경우
    printf("?");
  else
    printf("%c", max+'A');
 
  return 0;
}