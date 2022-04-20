// 헤더파일
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

int N, M;
int arr[9];
bool visited[9];

void DFS(int start, int check) {
	if (check == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = start; i <= N; i++) {
		if (!visited[i]) {
			visited[i] = true;
			arr[check] = i;
			DFS(i + 1, check + 1);
			visited[i] = false;
		}
	}
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	DFS(1, 0);
}