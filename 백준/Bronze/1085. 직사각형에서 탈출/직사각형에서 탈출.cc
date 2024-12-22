
// 직사각형에서 탈출 - https://www.acmicpc.net/problem/1085

#include <stdio.h>

int main(void) {

    int x, y, w, h; 
    scanf("%d%d%d%df", &x, &y, &w, &h);

    int min = h - y;
    if (y < min) min = y;
    if (x < min) min = x;
    if (w - x < min) min = w - x;

    printf("%d", min);

    return 0;
}