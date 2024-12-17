
// 후위 표기식 - https://www.acmicpc.net/problem/1918

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char ElementType;

// 스택 구조체
typedef struct {
    ElementType data[102];
    int top;
} Stack;

// 스택 생성
void CreateStack(Stack *Stack) {
    Stack->top = -1;
}

// 스택 삽입
void PushStack(Stack *Stack, ElementType Data) {
    Stack->data[++(Stack->top)] = Data;
}

// 스택 제거
ElementType PopStack(Stack *Stack) {
    return Stack->data[(Stack->top)--];
}

// 스택 peek
ElementType PeekStack(Stack *Stack) {
    return Stack->data[Stack->top];
}

// 스택 공백 확인
int is_empty(Stack *Stack) {
    return (Stack->top == -1);
}

int MyPriority(char ch) {
    if (ch == '+' || ch == '-')
        return 1;
    else if (ch == '*' || ch == '/')
        return 2;
    else 
        return 0;
    
}

int main(void) {

    char arr[102];
    scanf("%s", arr);
    
    char ch;
    Stack stack;
    CreateStack(&stack);

    int len = strlen(arr);
    for (int i = 0; i < len; i++) {
        ch = arr[i];
        switch (ch) {
        case '+': case '-': case '/': case '*':
            while (!is_empty(&stack) && MyPriority(PeekStack(&stack)) >= MyPriority(ch)) {
                printf("%c", PopStack(&stack));
            }
            PushStack(&stack, ch);
            break;
        case '(':
            PushStack(&stack, ch);
            break;
        case ')':
            while (PeekStack(&stack) != '(') {
                printf("%c", PopStack(&stack));
            }
            PopStack(&stack);
            break;
        default:
            printf("%c", ch);
            break;
        }
    }

    while (!is_empty(&stack))
    {
        printf("%c", PopStack(&stack));
    }
    return 0;
}