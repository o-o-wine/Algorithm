#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

// tc
int T;
// array
int N;
int arr[8][8];
bool visited[8][8];
// start = high list
vector<pair<int, int>>	start;
// direction
int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { 1, 0, -1, 0 };
// arrange depth
int K;
// Maxdist
int answer = 0;

// function
void DFS(int r, int c, int depth);
bool range_check(int r, int c);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;
	// tc loop
	for (int tc = 1; tc <= T; tc++) {
		start.clear();
		memset(visited, false, sizeof(visited));
		answer = 0;

		cin >> N >> K;
		// input
		int height = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				cin >> arr[r][c];
				height = max(height, arr[r][c]);
			}
		}
		// max height check
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (height == arr[r][c]) {
					start.push_back({ r, c });
				}
			}
		}

		// DFS

		for (int k = 0; k <= K; k++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] -= k;

					for (int len = 0; len < start.size(); len++) {
						memset(visited, false, sizeof(visited));
						visited[start[len].first][start[len].second] = true;
						DFS(start[len].first, start[len].second, 0);
					}

					arr[r][c] += k;
				}
			}
		}

		cout << "#" << tc << " " << answer + 1<< '\n';
	}

	return 0;
}

void DFS(int r, int c, int depth) {
	visited[r][c] = true;

	answer = max(answer, depth);

	// 상하좌우
	for (int i = 0; i < 4; i++) {
		int nr = r + dr[i];
		int nc = c + dc[i];

		if (!range_check(nr, nc))
			continue;

		if (visited[nr][nc])
			continue;

		if (arr[r][c] > arr[nr][nc]) {
			visited[nr][nc] = true;
			DFS(nr, nc, depth + 1);
			visited[nr][nc] = false;
		}
	}
}

bool range_check(int r, int c) {
	if (r < 0 || N <= r || c < 0 || N <= c) {
		return false;
	}

	return true;
}