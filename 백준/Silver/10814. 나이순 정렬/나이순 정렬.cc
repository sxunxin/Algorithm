
// 나이순 정렬 - https://www.acmicpc.net/problem/10814

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    int age;
    int order;
    char name[101];
} INFO;

int compare(const void *a, const void *b) {
    INFO *listA = (INFO *)a;
    INFO *listB = (INFO *)b;

    if (listA->age != listB->age) {
        return listA->age - listB->age;
    } else {
        return listA->order - listB->order;
    }
}

int main(void) {
    
    int n;
    scanf("%d", &n);
    INFO list[n];

    for (int i = 0; i < n; i++) {
        scanf("%d%s", &list[i].age, list[i].name);  
        list[i].order = i;
    }

    qsort(list, n, sizeof(INFO), compare);

    for (int i = 0; i < n; i++) {
        printf("%d %s\n", list[i].age, list[i].name);
    }

    return 0;
}