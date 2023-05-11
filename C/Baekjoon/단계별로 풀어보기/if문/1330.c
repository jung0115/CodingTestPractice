//백준 > 단계별로 풀어보기 > if문 > 두 수 비교하기(1330)
#include <stdio.h>
int main(void){
	int num1, num2;
	scanf("%d %d", &num1, &num2);
	
	if(num1 > num2)
		printf(">");
	else if(num1<num2)
		printf("<");
	else
		printf("==");
	
	return 0;
}