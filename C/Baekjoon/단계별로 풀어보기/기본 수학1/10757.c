//백준 > 단계별로 풀어보기 > 기본 수학1 > 큰 수 A+B(10757)
#include <stdio.h>
#include <string.h>
 
void change(char *num, int len); //문자열을 역순으로 재정렬
int main(void){
  char A[10002]={0}, B[10002]={0};
  int sum[10003]={0};
  int i, lenA, lenB, len;
 
  scanf("%s %s", A, B);
 
  lenA=strlen(A);
  change(A, lenA);
  lenB=strlen(B);
  change(B, lenB);
  
  for(i=0; i<lenA || i<lenB; i++){
    if(A[i]=='\0')
      A[i]='0';
    if(B[i]=='\0')
      B[i]='0';
    
    sum[i]+=(A[i]-'0')+(B[i]-'0');
    if(sum[i]>=10){
      sum[i+1]+=1;
      sum[i]-=10;
    }
  }
  if(sum[i]==0)
    i--;
 
  for(; i>=0; i--)
    printf("%d", sum[i]);
 
  return 0;
}
void change(char *num, int len){
  int i, temp;
  for(i=0; i<len/2; i++){
    temp=num[i];
    num[i]=num[len-i-1];
    num[len-i-1]=temp;
  }
}
/*
큰 정수의 합을 구하는 문제라서 변수의 자료형을 unsigned long long으로 선언하면 해당 범위까지 커버가 가능할 거라고 생각했다.
문제에 제시된 샘플값은 제대로 계산되었지만 채점해보니 틀렸다고 나왔다.
그래서 unsigned long long 대신 문자열로 받아서 계산하는 방법을 사용했다.
그리고 문자열이 입력되면 마지막 문자의 다음 인덱스값만 '\0'으로 채워지는 줄 알았는데, 그게 아니라 문자가 입력되지 않은 인덱스는 전부 '\0'으로 채워져 있는듯 했다.
*/