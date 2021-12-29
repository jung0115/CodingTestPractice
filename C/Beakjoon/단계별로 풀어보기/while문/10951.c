//백준 > 단계별로 풀어보기 > while문 > A+B -5(10951)
#include <stdio.h>
int main(void){
  int A, B;
 
  while( scanf("%d %d", &A, &B) != EOF ){
    printf("%d\n", A+B);
  }
 
  return 0;
}
//입력 중단 조건이 주어지지 않았을 때, 더이상 입력이 들어오지 않으면 반복문을 종료하도록 하는 방법.