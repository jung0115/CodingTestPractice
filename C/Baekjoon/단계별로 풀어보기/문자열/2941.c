//백준 > 단계별로 풀어보기 > 문자열 > 크로아티아 알파벳(2941)
#include <stdio.h>
 
int check(char a, char b, char c);
int main(void){
  char S[101];
  int i, cnt=0, checkResult;
 
  scanf("%s", S);
 
  for(i=0; S[i]!='\0'; i++){
    cnt++;
 
    if(S[i+1]=='\0')
      break;
    
    checkResult=check(S[i], S[i+1], S[i+2]);
    i+=checkResult;
  }
 
  printf("%d", cnt);
 
  return 0;
}
int check(char a, char b, char c){
  if(a=='d' && b=='z' && c=='=')
    return 2;
  
  else if(a=='c' && b=='=')
    return 1;
  
  else if(a=='c' && b=='-')
    return 1;
  
  else if(a=='d' && b=='-')
    return 1;
  
  else if(a=='l' && b=='j')
    return 1;
  
  else if(a=='n' && b=='j')
    return 1;
 
  else if(a=='s' && b=='=')
    return 1;
  
  else if(a=='z' && b=='=')
    return 1;
  
  return 0;
}