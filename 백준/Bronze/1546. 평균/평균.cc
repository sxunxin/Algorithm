#include <stdio.h>

int main(void) {

    int n, max=0;
    float avg=0;
    scanf("%d", &n);
    float arr[n];

    for ( int i = 0; i < n; i++ ) {
        scanf("%f", &arr[i]);
    }

    for ( int i = 0; i < n; i++ ) {
        if (max < arr[i]) {
            max = arr[i];
        }   
    }

    for ( int i = 0; i < n; i++ ) {
        avg += arr[i] / max * 100;
    }
    avg = avg / n;
    printf("%f", avg);


    return 0;
    
}
