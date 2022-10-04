#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int map[9][9] = { 0, };
bool finish = false;

// row 체크
bool row_check(int row, int col, int num) {
	//cout << "row" << '\n';
	for (int i = 0; i < 9; i++) {
		if (map[row][i] == num && col != i)
			return false;
	}

	return true;
}

// col 체크
bool col_check(int row, int col, int num) {
	//cout << "col" << '\n';
	for (int i = 0; i < 9; i++) {
		if (map[i][col] == num && row != i)
			return false;
	}

	return true;
}

// 3각형 박스 안 체크
bool box_check(int row, int col, int num) {
	//cout << "box" << '\n';
	// 3행
	for (int r = (row / 3) * 3; r < (row / 3) * 3 + 3; r++) {
		// 3열
		for (int c = (col / 3) * 3; c < (col / 3) * 3 + 3; c++) {
			if (row == r && col == c)
				continue;
			if(map[r][c] == num)
				return false;
		}
	}

	return true;
}

// 완전 탐색
void DFS(int row, int col) {
	
	// 종료조건
	if (row == 9) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				cout << map[r][c];
			}
			cout << '\n';
		}
		exit(0);
	}

	if (col == 9) {
		DFS(row + 1, 0);
		return;
	}

	if (map[row][col] == 0) {
		for (int i = 1; i <= 9; i++) {
			map[row][col] = i;
			if (row_check(row, col, i) && col_check(row, col, i) && box_check(row, col, i)) {
				DFS(row, col + 1);
			}
			map[row][col] = 0;
		}
	}
	else {
		DFS(row, col + 1);
	}
}

int main() {
	// stdio iostream 동기화 캔슬 안함 - scanf 써야됨
	//ios::sync_with_stdio(false);
	//cin.tie(NULL);

	// input
	for (int r = 0; r < 9; r++) {
		for (int c = 0; c < 9; c++) {
			scanf("%1d", &map[r][c]);
		}
	}

	// input check
	//for (int r = 0; r < 9; r++) {
	//	for (int c = 0; c < 9; c++) {
	//		cout << map[r][c] << ' ';
	//	}
	//	cout << '\n';
	//}

	DFS(0, 0);

	// 메인 함수 정상 종료
	return 0;
}