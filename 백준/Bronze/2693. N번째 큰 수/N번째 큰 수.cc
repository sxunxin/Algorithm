#include <stdio.h>

int main(void)
{
    int T;
    scanf("%d", &T);

    for (int k = 0; k < T; k++) {
        int arr[10];
        int temp;
        int max_i; 

        for (int i = 0; i < 10; i++) {
            scanf("%d", &arr[i]);
        }

        for (int i = 0; i < 3; i++) {
            max_i = i;
            for (int j = i; j < 10; j++) {
                if (arr[j] > arr[max_i]) {
                    max_i = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[max_i];
            arr[max_i] = temp;
        }
        printf("%d\n", arr[2]);
    }
	return 0;
}