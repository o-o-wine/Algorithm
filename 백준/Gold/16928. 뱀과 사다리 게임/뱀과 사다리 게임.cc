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

queue<int> q;
int arr[101];
int dist[101];
bool visited[101];

void BFS(int num) {
	dist[num] = 0;
	visited[num] = true;
	q.push(num);

	while (!q.empty()) {
		int x = q.front();
		q.pop();
		
		for (int i = 1; i <= 6; i++) {
			int y = x + i;

			if (y > 100)
				continue;
			if(arr[y] != 0)
				y = arr[y];

			if (!visited[y]) {
				dist[y] = dist[x] + 1;
				q.push(y);
				visited[y] = true;
			}
		}
	}
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;

	memset(arr, 0, sizeof(arr));

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
		arr[x] = y;
	}

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		arr[x] = y;
	}

	BFS(1);

	cout << dist[100] << '\n';

	return 0;
}
