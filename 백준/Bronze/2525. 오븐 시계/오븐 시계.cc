#include <stdio.h>

int main(void) {

    int h, m, x;
    scanf("%d %d", &h, &m);
    scanf("%d", &x);

    m = m + x;
    while ( m >= 60 )
    {
        m = m-60;
        h = h + 1;
    }

    if ( h>= 24) {
        h = h - 24;
    }
    
    printf("%d %d", h, m);

    return 0;

}