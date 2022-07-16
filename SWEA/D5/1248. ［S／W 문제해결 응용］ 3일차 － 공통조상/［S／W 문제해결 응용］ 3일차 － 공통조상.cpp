// Library
#include <iostream>
#include <string>
#include <stack>
#include <set>
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
#include <string>

// std::
using namespace std;

// Sturct
struct node {
	int index;
	int parent;
	int child[2];
};

// Test_case
int T, test_case;

// Value
int V, E;
int start[2];
int answer;
int dist[10001][2];
node tree[10001];

// Matrix direction
//int dx[4] = { 0, 0, 1, -1 };
//int dy[4] = { 1, -1, 0, 0 };

// 부모노드까지의 거리를 담는 DFS
void DFS(int n, int c, int idx) {
	dist[n][idx] = c;

	// 부모가 있으면
	if (tree[n].parent != 0) {
		DFS(tree[n].parent, c + 1, idx);
	}
}

int BFS(int n) {
	int c = 1;
	queue<int> q;

	q.push(n);

	while (!q.empty()) {
		int current = q.front();
		q.pop();

		for (int i = 0; i < 2; i++) {
			if (tree[current].child[i] != 0) {
				q.push(tree[current].child[i]);
				c++;

			}
		}
	}

	return c;
}

// Main function
int main() {
	// cin, cout
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// SWEA 양식
	// T = 10;
	cin >> T;
	for (test_case = 1; test_case <= T; test_case++) {
		// 초기화
		int size = 0;
		memset(dist, 0, sizeof(dist));
		for (int i = 0; i < 10001; i++) {
			tree[i].index = 0;
			tree[i].parent = 0;
			tree[i].child[0] = 0;
			tree[i].child[1] = 0;
		}
		
		// 입력
		cin >> V >> E;
		cin >> start[0] >> start[1];

		for (int i = 0; i < E; i++) {
			int p, c;
			cin >> p >> c;

			tree[p].child[tree[p].index++] = c;
			tree[c].parent = p;
		}

		// DFS로 부모까지의 거리 탐색
		for (int i = 0; i < 2; i++) {
			DFS(start[i], 0, i);
		}

		int tmp_dist[2] = { 987654, 987654 };

		// 목표 노드 위치 찾기
		for (int i = 1; i <= V; i++) {
			// 루트 노드 확인
			if (dist[i][0] != 0 && dist[i][1] != 0) {
				if (dist[i][0] < tmp_dist[0] && dist[i][1] < tmp_dist[1]) {
					tmp_dist[0] = dist[i][0];
					tmp_dist[1] = dist[i][1];
					answer = i;
				}
			}
		}

		size = BFS(answer);

		cout << "#" << test_case << " " << answer << " " << size << '\n';
	}
		
	return 0;
}