
// https://www.acmicpc.net/problem/16930

#include <stdio.h>
#include <string.h>

int main(void) {

    // --------------- 입력 파트 ---------------
    char arr[1000001];
    int cnt = 1;
    gets(arr);
    int n = strlen(arr);

    // --------------- 연산 파트 ---------------
    // 공백 개수 구하기
    for (int i = 0; i < n; i++) {
        if (arr[i] == 32) ++cnt;
    }

    // 처음, 끝 공백 개수 차감
    if (arr[0] == 32) --cnt;
    if (arr[n-1] == 32) --cnt;

    // --------------- 출력 파트 ---------------
    printf("%d", cnt);


    return 0;
}