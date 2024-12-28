#include <stdio.h>

void reverse(int* arr, int n, int start, int end);

int main(void) {

    int n, m, start, end;
    scanf("%d %d", &n, &m);
    int arr[n];

    for (int i = 1; i < n+1; i++) {
        arr[i-1] = i;
    }
    
    for (int i = 0; i < m; i++) {
        scanf("%d %d", &start, &end);
        reverse(arr, n, start, end);
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    
    return 0;
}

void reverse(int* arr, int n, int start, int end) {
    for (int i = 0; i < (end - start + 1) / 2; i++) {
        int temp = arr[start + i - 1];
        arr[start +i -1] = arr[end - i -1];
        arr[end-i -1] = temp;

    }
}