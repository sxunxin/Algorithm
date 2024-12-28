#include <stdio.h>

int main(void) {

    int n, max=-1000000, min=1000000;
    scanf("%d", &n);
    int arr[n];

    for ( int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    for ( int i = 0; i < n; i++) {
        if (min > arr[i]) {
            min = arr[i];
        }
        if (max < arr[i]) {
            max = arr[i];
        }
    }

    printf("%d %d", min, max);



    return 0;

}
