//백준 > 단계별로 풀어보기 > 문자열 > 그룹 단어 체커(1316)
#include <stdio.h>
 
int check(char *S, int *alphabet);
void setting(int *alphabet);
int main(void){
  char S[101];
  int N, alphabet[26]={0}, i, c, cnt=0;
 
  scanf("%d", &N);
 
  for(i=0; i<N; i++){
    scanf("%s", S);
    c=check(S, alphabet);
    setting(alphabet);
    if(c==1)
      cnt++;
  }
 
  printf("%d", cnt);
 
  return 0;
}
int check(char *S, int *alphabet){
  int i, num;
 
  for(i=0; S[i]!='\0'; i++){
    num=S[i]-'a';
    if(alphabet[num]!=0 && S[i-1]!=S[i])
      return 0;
    else if(alphabet[num]==0)
      alphabet[num]++;
  }
  return 1;
}
void setting(int *alphabet){
  int i;
 
  for(i=0; i<26; i++)
    alphabet[i]=0;
}