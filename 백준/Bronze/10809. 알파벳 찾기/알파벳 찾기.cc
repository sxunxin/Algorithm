#include <stdio.h>
#include <string.h>

int main(void) {

    char arr[101];
    char list[26];

    for (int i = 0; i < 26; i++) {
        list[i] = -1;
    }

    scanf("%s", arr);
    int sizeArr = strlen(arr);

    for (int i = 0; i < sizeArr; i++) {
        if (list[(int)arr[i] - 97] == -1)
            list[(int)arr[i] - 97] += i+1;
    } 

    for (int i = 0; i < 26; i++) {
        printf("%d ",list[i]);
    } 

    return 0;
}