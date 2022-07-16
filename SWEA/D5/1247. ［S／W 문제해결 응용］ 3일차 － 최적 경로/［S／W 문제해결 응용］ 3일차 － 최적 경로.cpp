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
struct point {
	int x;
	int y;
};

// Test_case
int T, test_case;

// Value
int N;
point arr[10];
point home;
point comp;
bool visit[10] = { false };
int minl = 987654;

// Matrix direction
//int dx[4] = { 0, 0, 1, -1 };
//int dy[4] = { 1, -1, 0, 0 };

// Dist
int dist(point a, point b) {
	return abs(a.x - b.x) + abs(a.y - b.y);
}

void DFS(int d, point p, int len)
{
	if (d == N)	{
		minl = min(minl, len + dist(p, comp));
		return;
	}
	else if (len > minl) {
		return;
	}

	for (int i = 0; i < N; i++)	{
		if (!visit[i]) {
			visit[i] = true;
			DFS(d + 1, arr[i], len + dist(p, arr[i]));
			visit[i] = false;
		}
	}
	return;
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
		
		cin >> N;

		minl = 987654;
		memset(visit, false, sizeof(visit));

		cin >> comp.x >> comp.y;
		cin >> home.x >> home.y;

		for (int i = 0; i < N; i++) {
			cin >> arr[i].x >> arr[i].y;
		}
		
		DFS(0, home, 0);

		cout << "#" << test_case << " " << minl << '\n';
	}
		
	return 0;
}
