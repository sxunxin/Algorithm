#include <stdio.h>

int main(void) {

    int size, x;
    scanf("%d %d", &size, &x);

    int arr[size];
    for ( int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }


    for ( int i = 0; i < size; i++) {
        if (arr[i] < x) {
            printf("%d ", arr[i]);
        }
    }

    return 0;

}
