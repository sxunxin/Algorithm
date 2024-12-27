#include <stdio.h>
#include <string.h>

int main(void) {

    int cnt = 0;

    scanf("%d", &cnt);

    for (int i = 0; i < cnt; i++) {
        int cnt2 = 0;
        char arr[21];
        scanf("%d", &cnt2);
        scanf("%s", arr);


        for (int j = 0; j < strlen(arr); j++) {
            for (int k = 0; k < cnt2; k++) 
                printf("%c",arr[j]);
        }
        printf("\n");
    }

    return 0;
}