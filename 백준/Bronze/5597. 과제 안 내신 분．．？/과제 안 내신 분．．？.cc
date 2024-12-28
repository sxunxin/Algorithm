#include <stdio.h>

int main(void) {

    int arr[30];
    int check = 0;

    for (int i = 0; i < 30; i++) {
        arr[i] = i+1;
    }

    for (int i = 0; i < 28; i++) {
        scanf("%d", &check);
        arr[check-1] = 0;
    }

    for (int i = 0; i < 30; i++) {
        if ( arr[i] != 0)
            printf("%d\n", arr[i]);
    }

    return 0;
}