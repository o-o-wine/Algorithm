// 헤더파일
#define ll long long int
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

int caa = 0;
int mmap[20][20];
int baby_size = 2;
int sizecnt = 0;
int mdistance = 0;
int visited[20][20];
int N, startx, starty;
vector <pair <pair<int, int>, int>> eat;

int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };

bool check(int y, int x) {
	if (y < 0 || y >= N || x < 0 || x >= N)
		return false;
	else
		return true;
}

// 시간을 재야해서 못 씀
/*
bool sorting(pair <int, int> p, pair <int, int> p2) {
	int v1, v2;
	v1 = p.first + p.second;
	v2 = p2.first + p.second;

	if (v1 == v2) {
		if (p.first == p2.first)
			return p.second < p2.second;
		else
			return p.first < p2.first;
	}

	return v1 < v2;
}
*/

void BFS(int y, int x) {
	eat.clear();
	memset(visited, 0, sizeof(visited));

	int eat_distance = 1e5;
	queue<pair<int, int>> q;

	//visited[y][x] = 1;
	q.push({ y, x });

	while (!q.empty()) {
		int px = q.front().second;
		int py = q.front().first;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + px;
			int ny = dy[i] + py;

			if (visited[ny][nx] == 0 && check(ny, nx) && baby_size >= mmap[ny][nx]) {
				visited[ny][nx] = visited[py][px] + 1;

				if (baby_size > mmap[ny][nx] && mmap[ny][nx] > 0) {
					if (eat_distance >= visited[ny][nx]) {
						eat_distance = visited[ny][nx];
						eat.push_back({ { eat_distance, ny }, nx });
						//cout << "dis = " << eat_distance << '\n';
					}
				}

				q.push({ ny, nx });
			}
		}
	}
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> mmap[i][j];
			if (mmap[i][j] == 9) {
				mmap[i][j] = 0;
				startx = j;
				starty = i;
			}
		}
	}

	while (1) {
		BFS(starty, startx);
		//cout << "sy = " << starty << "| sx = " << startx << '\n';
		if (eat.empty())
			break;

		else {
			sort(eat.begin(), eat.end());

			sizecnt++;
			mdistance += eat[0].first.first;
			mmap[eat[0].first.second][eat[0].second] = 0;
			startx = eat[0].second;
			starty = eat[0].first.second;
			if (baby_size == sizecnt) {
				baby_size++;
				sizecnt = 0;
			}
		}
	}

	cout << mdistance << '\n';
}
