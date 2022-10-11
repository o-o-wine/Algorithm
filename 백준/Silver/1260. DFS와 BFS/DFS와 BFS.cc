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

using namespace std;

vector<int> v[1001];
queue<int> q;
int dvisited[1001];
int bvisited[1001];
int N, M, V;

void dfs(int s) {
	if (dvisited[s] == 1)
		return;
	sort(v[s].begin(), v[s].end());
	dvisited[s] = 1;
	cout << s << " ";

	for (int i = 0; i < v[s].size(); i++) {
		int c = v[s][i];
		dfs(c);
	}
}

void bfs(int s) {
	q.push(s);
	bvisited[s] = 1;

	while (!q.empty()) {
		int c = q.front();
		q.pop();
		cout << c << " ";
		
		for (int i = 0; i < v[c].size(); i++) {
			int num = v[c][i];

			if (bvisited[num] != 1) {
				q.push(num);
				bvisited[num] = 1;
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M >> V;
	for (int i = 0; i < M; i++) {
		int sp, ep;

		cin >> sp >> ep;
		v[sp].push_back(ep);
		v[ep].push_back(sp);
	}
	dfs(V);
	cout << '\n';
	bfs(V);
}