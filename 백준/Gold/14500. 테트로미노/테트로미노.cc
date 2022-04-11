#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <deque>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <map>
#include <cctype>
#include <set>
#include <string.h>

using namespace std;

// 변수 선언부
int N, M, flag = 0, sum = 0, result = 0;
int arr[500][500] = { 0 };
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
bool visited[500][500] = { false };

// 기능 함수 선언부
bool size_check(int y, int x) {
	if (y >= 0 && y < N && x < M && x >= 0)
		return true;
	return false;
}

void DFS(int y, int x, int check, int flag) {
	visited[y][x] = true;
	
	if (flag == 3) {
		result = max(check, result);
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (size_check(ny, nx) && !visited[ny][nx]) {
			DFS(ny, nx, check + arr[ny][nx], flag + 1);
			visited[ny][nx] = false;
		}
	}
}

void shape1(int y, int x) {
	int ssum = 0;
	ssum = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1];
	result = max(result, ssum);
}
void shape2(int y, int x) {
	int ssum = 0;
	ssum = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1];
	result = max(result, ssum);
}
void shape3(int y, int x) {
	int ssum = 0;
	ssum = arr[y][x] + arr[y][x + 1] + arr[y-1][x + 1] + arr[y + 1][x + 1];
	result = max(result, ssum);
}
void shape4(int y, int x) {
	int ssum = 0;
	ssum = arr[y][x] + arr[y+1][x] + arr[y+2][x] + arr[y + 1][x + 1];
	result = max(result, ssum);
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			cin >> arr[y][x];
		}
	}

	for (int y = 0; y < N; y++) {
		for (int x = 0; x < M; x++) {
			memset(visited, false, sizeof(visited));
			DFS(y, x, arr[y][x], 0);
			if (y - 1 >= 0 && x + 2 < M)
				shape1(y, x);
			if (y + 1 < N && x + 2 < M)
				shape2(y, x);
			if (y - 1 >= 0 && y + 1 < N && x + 1 < M)
				shape3(y, x);
			if (y + 2 < N && x + 1 < M)
				shape4(y, x);

		}
	}

	cout << result << '\n';
}