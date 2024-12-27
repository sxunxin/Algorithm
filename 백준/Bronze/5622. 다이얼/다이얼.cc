
// 다이얼 - https://www.acmicpc.net/problem/5622

#include <stdio.h>
#include <string.h>

int main(void) {
    
    // --------------- 입력 파트 ---------------
    char arr[16];
    int cnt = 0;
    scanf("%s", arr);
    int len = strlen(arr);

    // --------------- 연산 파트 ---------------
    for (int i = 0; i < len; i++) {
        cnt += ( (int)arr[i] - 65 ) / 3 + 3;
        if (arr[i] == 'S' || arr[i] == 'V' || arr[i] == 'Y' || arr[i] == 'Z' ) --cnt;
    }

    // --------------- 출력 파트 ---------------
    printf("%d", cnt);

    return 0;
}