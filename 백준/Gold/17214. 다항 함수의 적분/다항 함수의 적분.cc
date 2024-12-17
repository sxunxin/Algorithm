
// 다항 함수의 적분 - https://www.acmicpc.net/problem/17214

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {

    // 3가지 형태의 입력 ( 5x , 5, 5x+5 )
    // 0 조심, 1 조심 , +/- 조심

    char arr[20];
    scanf("%s", arr);

    // 상수항만 있는 경우
    if (strchr(arr,'x') == NULL) {
        if (atoi(arr) == 0) printf("W");  
        else if (atoi(arr) == 1) printf("x+W");  
        else if (atoi(arr) == -1) printf("-x+W"); 
        else printf("%dx+W", atoi(arr)); 
    }
    // 일차항만 있는 경우 or 일차항, 상수항 둘 다 있는 경우
    else { 
        if (atoi(arr)/2 == 1) printf("xx");
        else if (atoi(arr)/2 == -1) printf("-xx");
        else printf("%dxx", atoi(arr)/2); 

        if (*(strchr(arr,'x')+1) == '+' || *(strchr(arr,'x')+1) == '-') {
            if (*(strchr(arr,'x')+2) == '0') printf("+W"); 
            else if (*(strchr(arr,'x')+2) == '1' && *(strchr(arr,'x')+3) == '\0') {
                if (*(strchr(arr,'x')+1) == '+') printf("+x+W");
                else if (*(strchr(arr,'x')+1) == '-') printf("-x+W");                
            }
            else printf("%sx+W",strchr(arr,'x')+1);     
        }
        else printf("+W");
    }

    return 0;
}