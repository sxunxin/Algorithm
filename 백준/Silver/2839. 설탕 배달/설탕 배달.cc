
// 설탕 배달 - https://www.acmicpc.net/problem/2839

#include <stdio.h>

int main(void) {

    int n, tmp;
    scanf("%d", &n);

    for (int i = 1000; i > -1; i--) {
        if ((i * 5) < n+1) {
            tmp = n - (i * 5);
            for (int j = 1700; j > -1; j--) {
                if ( tmp - (j * 3) == 0 ) {
                    printf("%d", i + j);
                    return 0;
                }
            }
        }
    }
    printf("-1");
    return 0;
}