
// 좌표 정렬하기 - https://www.acmicpc.net/problem/11650

#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {

    int *pA = (int *)a;
    int *pB = (int *)b;

    if (pA[0] == pB[0]) return pA[1] - pB[1];
    else return pA[0] - pB[0];
}


int main(void) {

    int n;
    scanf("%d", &n);
    int arr[n][2];

    for (int i = 0; i < n; i++) {
        scanf("%d%d", &arr[i][0], &arr[i][1]);
    }

    qsort(arr, n, sizeof(arr[0]), compare);

    for (int i = 0; i < n; i++) {
        printf("%d %d\n", arr[i][0], arr[i][1]);
    }

    return 0;
}