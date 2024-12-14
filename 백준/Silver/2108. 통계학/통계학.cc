
// 통계학 - https://www.acmicpc.net/problem/2108

#include <stdio.h>
#include <math.h>

void quicksort(int arr[], int left, int right) {
    int i = left, j = right;
    int pivot = arr[(left + right) / 2];
    int temp;

    while (i <= j) {
        while (arr[i] < pivot) i++;
        while (arr[j] > pivot) j--;
        if (i <= j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    if (left < j) quicksort(arr, left, j);
    if (i < right) quicksort(arr, i, right);
}

int main(void) {
    int n;
    int arr[500000];
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // 산술평균
    double sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }
    double mean = round((double)sum / n);
    if (mean == -0.0) mean = 0.0;
    printf("%.0f\n", mean);

    // 중앙값
    quicksort(arr, 0, n - 1);
    printf("%d\n", arr[n / 2]);

    // 최빈값
    int arr2[8001] = {0};
    int cnt = 0;
    int mode = 0;
    int modeCnt = 0;

    for (int i = 0; i < n; i++) {
        arr2[arr[i] + 4000]++;
    }
    for (int i = 0; i < 8001; i++) {
        if (arr2[i] > cnt) {
            cnt = arr2[i];
        }
    }
    for (int i = 0; i < 8001; i++) {
        if (arr2[i] == cnt) {
            if (modeCnt == 0) {
                mode = i;
                modeCnt++;
            } else if (modeCnt == 1) {
                mode = i;
                break;
            }
        }
    }
    printf("%d\n", mode - 4000);

    // 범위
    int max = -4001;
    int min = 4001;

    for (int i = 0; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    printf("%d", max - min);

    return 0;
}
