#include <stdio.h>

int main(void) {

    int max=0, count;
    int arr[9];

    for ( int i = 0; i < 9; i++) {
        scanf("%d", &arr[i]);
    }

    for ( int i = 0; i < 9; i++) {
        if (max < arr[i]) {
            max = arr[i];
            count = i+1;
        }
    }

    printf("%d\n%d", max, count);


    return 0;

}
