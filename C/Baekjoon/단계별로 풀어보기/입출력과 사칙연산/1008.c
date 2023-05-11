//백준 > 단계별로 풀어보기 > 입출력과 사칙연산 > A/B(1008)
#include <stdio.h>
int main(void){
    double A, B;
    scanf("%lf %lf", &A, &B);
    printf("%.9lf", A/B);
    return 0;
}
//조건에서 이야기한 오차부분을 맞추려면 정수를 입력 받더라도 double형으로 입력 받아주어야 문제가 없음.