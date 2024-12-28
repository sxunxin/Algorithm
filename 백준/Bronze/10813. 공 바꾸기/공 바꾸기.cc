#include <stdio.h>

int main(void) {

    int n, m, a, b, k;
    scanf("%d %d", &n, &m);
    int arr[n];

    for (int i = 0; i < n; i++) {
        arr[i] = i+1;
    }

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &a, &b);
        k = arr[a-1];
        arr[a-1] = arr[b-1];
        arr[b-1] = k;
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }    

    return 0;
}
