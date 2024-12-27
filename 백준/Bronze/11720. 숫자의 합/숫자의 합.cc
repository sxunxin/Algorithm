#include <stdio.h>

int main(void) {

    int cnt = 0, sum = 0, total = 0;

    scanf("%d", &cnt);

    for ( int i = 0; i < cnt; i++ ) {
        scanf("%1d", &sum);
        total += sum;
    }

    printf("%d", total);

    return 0;
}