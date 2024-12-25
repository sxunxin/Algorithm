
// 세로읽기 - https://www.acmicpc.net/problem/10798

#include <stdio.h>

int main(void) {

    char arr[5][16] = { NULL, };

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 16; j++) {
			scanf("%c", &arr[i][j]);
			if (arr[i][j] == '\n') break;
		}
	}

    for (int j = 0; j < 16; j++) {
		for (int i = 0; i < 5; i++) {
			if ((arr[i][j] == '\n') || (arr[i][j] == NULL))
				printf("");
			else
				printf("%c", arr[i][j]);
		}
	}

    return 0;
}
