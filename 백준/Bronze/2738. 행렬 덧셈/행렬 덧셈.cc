#include <stdio.h>

int main(void) {

    int n = 0, m = 0;
    scanf("%d %d", &n, &m);
    int arrA[n][m];
    int arrB[n][m];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &arrA[i][j]);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &arrB[i][j]);
            arrA[i][j] += arrB[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", arrA[i][j]);
        }
        printf("\n");
    }

    return 0;
}