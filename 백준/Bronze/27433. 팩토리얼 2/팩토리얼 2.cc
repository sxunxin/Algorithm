#include <stdio.h>
#include <stdlib.h>

int main(void)
{

    int num = 0;
    long long int total = 1;
    scanf("%d", &num);

    for (int i = 1; i <= num; i++) {
        total *= i;
    }
    
    printf("%lld", total);
	return 0;
}