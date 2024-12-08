
// 기찍 N - https://www.acmicpc.net/problem/2742

#include <stdio.h>

int main (void) {
    int N;

    scanf("%d", &N);

    for (int i = N; i > 0; i--) {
        printf("%d\n", i);
    }
}