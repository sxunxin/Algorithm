
// 20. 약수들의 합(중)
// https://www.acmicpc.net/problem/9506

#include <stdio.h>

int main(void) {

    while(1) {

        int n = 0;
        int sum = 0;
        int cnt = 0;

        scanf("%d", &n);
        if (n == -1) break;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
                cnt += 1;
            }
        }

        if (sum == n) {
            printf("%d = ", n);
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    printf("%d ", i);
                    cnt -= 1;
                    if (cnt != 0) 
                        printf("+ ");
                    else printf("\n");
                }
            }

        } 
        else printf("%d is NOT perfect.\n", n);
    }

    return 0;
}
