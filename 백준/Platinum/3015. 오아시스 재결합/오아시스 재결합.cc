
// 오아시스 재결합 - https://www.acmicpc.net/problem/3015

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct height_size {
    int height;
    int size;
};

void printStack(struct height_size stack[], int top, long cnt) {
    printf("[ ");
    for (int i = 0; i < top+1; i++) {
        printf("%d ", stack[i].height);
    }
    printf("]\ncnt : %ld\n", cnt);
}

int main(void) {

    int n, top = -1;
    long cnt = 0;
    struct height_size stack[500002];
    struct height_size node;
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &node.height);
        node.size = 1;

        while (top != -1 && node.height >= stack[top].height) {
            cnt += stack[top].size;

            if (node.height == stack[top].height) 
                node.size += stack[top].size;
            
            top--;
        }

        if (top != -1) 
            cnt++;

        stack[++top] = node;
        // printStack(stack, top, cnt);
    }
    
    printf("%ld", cnt);
    return 0;
}