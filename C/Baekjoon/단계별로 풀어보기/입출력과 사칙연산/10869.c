//백준 > 단계별로 풀어보기 > 입출력과 사칙연산 > 사칙연산(10869)
#include <stdio.h>
int main(void){
    int A, B;
    scanf("%d %d", &A, &B);
  
    printf("%d\n", A+B);
    printf("%d\n", A-B);
    printf("%d\n", A*B);
    printf("%d\n", A/B);
    printf("%d", A%B);
    return 0;
}