#include <stdio.h>

int main(void) {

    char s[1001] = { 0 };
    int n = 0;

    scanf("%s", s);
    scanf("%d", &n);

    printf("%c", s[n-1]);

    return 0;
}