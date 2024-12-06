
// 수 찾기 - https://www.acmicpc.net/problem/1920

#include <stdio.h>
#include <string.h>
#define SIZE 100000

int a[SIZE];
int temp[SIZE]; 

void merge(int start, int mid, int end) {
    int i = start, j = mid + 1, k = start;

    while (i <= mid && j <= end) {
        if (a[i] <= a[j]) temp[k++] = a[i++];
        else temp[k++] = a[j++];
    }

    while (i <= mid) temp[k++] = a[i++];
    while (j <= end) temp[k++] = a[j++];

    for (i = start; i <= end; i++) {
        a[i] = temp[i];
    }
}

void mergeSort(int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, mid, end);
    }
}

int binsearch(int data[], int n, int key) {
    int low = 0, high = n - 1, mid;

    while (low <= high) {
        mid = (low + high) / 2;
        if (key == data[mid]) {
            return 1;
        } else if (key < data[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return 0;
}

int main() {
    int n, cnt, key;

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }
    mergeSort(0, n - 1);

    scanf("%d", &cnt);
    for (int i = 0; i < cnt; i++) {
        scanf("%d", &key);
        printf("%d\n", binsearch(a, n, key));
    }
    return 0;    
}
