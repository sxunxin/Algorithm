
// 상수 - https://www.acmicpc.net/problem/2908

#include <stdio.h>

int a[3], b[3];

void prt(int n);

int main(void) {

    // --------------- 입력 파트 ---------------
    
    int tmp;
    
    for (int i = 0; i < 3; i++) {
        scanf("%1d", &a[i]);
    }
    for (int i = 0; i < 3; i++) {
        scanf("%1d", &b[i]);
    }
    
    // --------------- 연산 파트 ---------------

    if (a[2] > b[2]) prt(1);
    else if (a[2] < b[2]) prt(2);
    else {
        if (a[1] > b[1]) prt(1);
        else if (a[1] < b[1]) prt(2);
        else {
            if (a[0] > b[0]) prt(1);
            else if (a[0] < b[0]) prt(2);
        }
    }

    return 0;
}

// --------------- 출력 파트 ---------------
void prt(int n) {
    if (n==1) {
        for(int i = 2; i > -1; i--) {
            printf("%d", a[i]);
        }
    } else {
        for(int i = 2; i > -1; i--) {
            printf("%d", b[i]);
        }
    }
}