#include <stdio.h>

int main(void) {

    int sum, size, price, num, sum_test = 0;
    scanf("%d", &sum);
    scanf("%d", &size);

    for (int i = 1; i <= size; i++ ) {
        scanf("%d %d",&price, &num);
        sum_test += price*num;
    }
    
    if (sum == sum_test) {
        printf("Yes");
    } else {
        printf("No");
    }

    return 0;

}
