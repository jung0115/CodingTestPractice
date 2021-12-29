//백준 > 단계별로 풀어보기 > 함수 > 셀프 넘버(4673)
#include <stdio.h>
 
int numCal(int num);//생성자가 입력되면 계산해서 다음 수열을 출력으로 내보냄
int main(void){
  int i, funcResult, notSelfNumber[10001]={0};
 
  for(i=1; i<=10000; i++){
    funcResult=numCal(i);
    if(funcResult<=10000) //생성자가 있는 수, 즉 셀프 넘버가 아닌 수
      notSelfNumber[funcResult]=1;
  }
 
  for(i=1; i<=10000; i++){
    if(notSelfNumber[i]==0){ //생성자가 없는 수, 즉 셀프 넘버
      printf("%d\n", i);
    }
  }
 
  return 0;
}
int numCal(int num){
  int sum=num;
 
  while(num>0){
    sum+=num%10;
    num/=10;
  }
 
  return sum;
}

/*
처음에는 셀프 넘버를 구하기 위해 1부터 10000까지의 수를 for문으로 반복시키고, 각 수마다 '자신보다 작은 수 중 자신의 생성자가 있는지' 파악하는 구조로 구현.
이 방법은 답을 얻을 수는 있으니, 시간이 오래 걸린다는 문제.(time limited)
해결: 1부터 10000까지를 모두 생성자로 하여 계산한 결과값에 표시해두는 방법 이용(배열의 해당 인덱스에 1 할당)
1부터 10000까지의 수 중 생성자가 있는 수를 모두 찾아내어 나머지 수를 출력하는 방법이다. 이 방법이 앞선 방법보다 시간을 훨씬 절약한다.
*/