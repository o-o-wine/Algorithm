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
bool visited[100][100];
int N, nm = 0, abnm = 0;
char arr[100][100];

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

bool size_check(int x, int y) {
	if (y >= 0 && x >= 0 && x < N && y < N)
		return true;
	else
		return false;
}

void BFS(int a, int b) {
	queue<pair<int, int>> q;
	q.push({a, b});
	visited[a][b] = true;

	//char check = arr[y][x];

	while (!q.empty()) {
		int y = q.front().second;
		int x = q.front().first;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (size_check(nx, ny) && !visited[nx][ny] && arr[nx][ny] == arr[x][y]) {
				visited[nx][ny] = true;
				q.push({ nx, ny });
			}
		}
	}
}

void change_blind() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (arr[i][j] == 'R')
				arr[i][j] = 'G';
		}
	}
}

int main() { 
	/*
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	*/

	cin >> N;
	for (int i = 0; i < N; i++) {
		scanf("%s", &arr[i]);
	}

	memset(visited, false, sizeof(visited));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j]) {
				BFS(i, j);
				nm++;
			}
		}
	}

	change_blind();

	memset(visited, false, sizeof(visited));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j]) {
				BFS(i, j);
				abnm++;
			}
		}
	}

	cout << nm << ' ' << abnm << '\n';
}
