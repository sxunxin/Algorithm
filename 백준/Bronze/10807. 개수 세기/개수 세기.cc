#include <stdio.h>

int main(void) {

    int size, v, found = 0;

    scanf("%d", &size);
    int arr[size];

    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
    scanf("%d", &v);

    for (int i = 0; i < size; i++) {
        if ( arr[i] == v) {
            found += 1;
        }
    }
    printf("%d", found);


    return 0;

}
