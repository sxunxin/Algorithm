
// 피보나치 수 5 - https://www.acmicpc.net/problem/10870

#include <stdio.h>

int fibonacci(int n) {
	if (n == -1) return 0;
    else if (n == 1 || n == 0) return 1;
	else return (fibonacci(n-1) + fibonacci(n-2));
}

int main(void) {

    int n = 0;
    scanf("%d", &n);
    printf("%d", fibonacci(n-1));

    return 0;
}