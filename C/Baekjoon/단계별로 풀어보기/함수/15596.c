//백준 > 단계별로 풀어보기 > 함수 > 정수 N개의 합(15596)
#include <stdio.h>
long long sum(int *a, int n){
  int i;
  long long result=0;
 
  for(i=0; i<n; i++)
    result += a[i];
  
  return result;
}
//main 함수까지 다 작성하는 것이 아니라 sum 함수만 구현해서 제출하면 되는 문제
//지금까지 C언어로 구현한 코드를 제출할 때 제출 언어를 C++17로 선택해서 제출했다. 하지만 이 경우 함수만 제출하는 것이라 그런지 문제가 발생해 제출 언어를 C11로 바꾸어 제출했다.