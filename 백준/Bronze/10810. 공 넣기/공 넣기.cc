#include <stdio.h>

int main(void) {

    int n, m, start, end, num;
    scanf("%d %d", &n, &m);

    int arr[n];

    for ( int a = 0; a < n; a++ ) {
        arr[a] = 0;
    }

    for ( int i = 0; i < m; i++ ) {
        scanf("%d %d %d", &start, &end, &num);

        for ( int j = start-1; j < end; j++ ) {
            arr[j] = num;
        }
    }

    for (int k = 0; k < n; k++ ) {
        printf("%d ", arr[k]);
    }

    return 0;

}
