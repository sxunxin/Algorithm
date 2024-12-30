#include <stdio.h>

int main(void) {

    int h, m;
    scanf("%d %d", &h, &m);

    m -= 45;

    if ( m >= 0 )
        printf("%d %d", h , m);
    else {
        m = m + 60;
        h = h - 1;

        if ( h == -1 )
            printf("23 %d", m);
        else 
            printf("%d %d", h , m);
    }
    return 0;
}