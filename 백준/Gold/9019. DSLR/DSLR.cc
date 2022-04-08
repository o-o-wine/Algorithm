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
bool visited[10000];
int T, a, b;

void BFS(void) {
	queue<pair<int, string>> q;
	q.push({ a, "" });
	visited[a] = true; 

	while (!q.empty()) {
		int num = q.front().first;
		string cmd = q.front().second;

		q.pop();

		if (num == b) {
			cout << cmd << '\n';
			return;
		}

		int D, S, L, R;

		D = (num * 2) % 10000;
		if (!visited[D]) {
			visited[D] = true;
			q.push({ D, cmd + "D" });
		}

		S = (num - 1) < 0 ? 9999 : num - 1;
		if (!visited[S]) {
			visited[S] = true;
			q.push({ S, cmd + "S" });
		}

		L = num % 1000 * 10 + num / 1000;
		if (!visited[L]) {
			visited[L] = true;
			q.push({ L, cmd + "L" });
		}

		R = num / 10 + num % 10 * 1000;
		if (!visited[R]) {
			visited[R] = true;
			q.push({ R, cmd + "R" });
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> a >> b;
		memset(visited, false, sizeof(visited));
		BFS();
	}
}