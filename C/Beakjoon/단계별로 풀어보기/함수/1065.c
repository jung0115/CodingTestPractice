//백준 > 단계별로 풀어보기 > 함수 > 한수(1065)
#include <stdio.h>
 
void HanSuCheck(int N, int *HanSu); //한수 체크
int main(void){
  int HanSu[1001]={0}, N, i, cnt=0;
 
  scanf("%d", &N);
 
  HanSuCheck(N, HanSu);
 
  for(i=1; i<=N; i++){
    if(HanSu[i]==1)
      cnt++;
  }
 
  printf("%d", cnt);
 
  return 0;
}
void HanSuCheck(int N, int *HanSu){
  int i, num[3];
  for(i=1; (i<100)&&(i<=N); i++) //한 자리 수와 두 자리 수는 모두 한수
    HanSu[i]=1;
  
  for(i=100; i<=N; i++) { //세 자리 수 확인 + 1000은 한수가 아니므로 계산 X
    num[0]=i%10; //셋째자리
    num[1]=(i/10)%10; //둘째자리
    num[2]=i/100; //첫째자리
    if((num[0]-num[1])==(num[1]-num[2]))
      HanSu[i]=1;
  }
}