//백준 > 단계별로 풀어보기 > 입출력과 사칙연산 > 곱셈(2588)
#include <stdio.h>
int main(void){
    int num1, num2;
    scanf("%d %d", &num1, &num2);
  
    printf("%d\n", num1*(num2%10));
    printf("%d\n", num1*(num2%100/10));
    printf("%d\n", num1*(num2/100));
    printf("%d", num1*num2);
 
    return 0;
}