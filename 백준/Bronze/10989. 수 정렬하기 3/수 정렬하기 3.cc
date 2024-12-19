
// 수 정렬하기 - https://www.acmicpc.net/problem/10989

#include <stdio.h>

int main() {

    // 카운팅 정렬 사용
    int n;
    scanf("%d", &n);
    int count[10001] = {0};

    for (int i = 0; i < n; i++) {
        int input;
        scanf("%d", &input);
        count[input]++;
    }

    for (int i = 1; i <= 10000; i++) {
        while (count[i] > 0) {
            printf("%d\n", i);
            count[i]--;
        }
    }

    return 0;
}
