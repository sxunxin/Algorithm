
// 더하기 사이클 - https://www.acmicpc.net/problem/1110

#include <stdio.h>

int main(void) {

    int N, sum, cnt = 0;
    scanf("%d", &N);

    int tmp = N;

    do {
        sum = ((tmp / 10) + (tmp % 10)) % 10;
        tmp = ((tmp % 10) * 10) + sum;
        cnt++;
    } while (N != tmp);

    printf("%d", cnt);

    return 0;
}