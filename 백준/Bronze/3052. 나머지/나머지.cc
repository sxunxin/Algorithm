#include <stdio.h>

int main(void) {

    int n, count = 0;
    int arr[10];
    for (int i = 0; i < 10; i++) {
        scanf("%d", &n);
        arr[i] = n % 42;
    }


    for (int i = 0; i < 43; i++) {
          for (int j = 0; j < 10; j++) {
            if (arr[j] == i) {
                count += 1;
                break;
            }
          }
    }

    printf("%d", count);
    
    return 0;
}
