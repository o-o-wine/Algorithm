#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

// value;
int T;
vector<int> v[4];

// func;
void solve(int target, int direction);
void rotate(int target, int direction);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		int N;
		cin >> N;

		// 입력 받자.
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				int c;
				cin >> c;
				v[i].push_back(c);
			}
		}

		for (int i = 0; i < N; i++) {
			// 목표 톱니바퀴랑 방향
			int target, direction;
			cin >> target >> direction;
			solve(target - 1, direction);
		}

		int answer = 0;
		for (int i = 0; i < 4; i++) {
			if (v[i].at(0) == 1)
				answer += pow(2, i);
		}
		
		for (int i = 0; i < 4; i++) {
			v[i].clear();
		}

		cout << "#" << tc << " " << answer << '\n';
	}

	return 0;
}

void solve(int target, int dir) {
	if (target == 0) {
		if (v[0].at(2) != v[1].at(6)) {
			if (v[1].at(2)!= v[2].at(6)) {
				if (v[2].at(2) != v[3].at(6)) {
					rotate(3, -dir);
				}
				rotate(2, dir);
			}
			rotate(1, -dir);
		}
		rotate(0, dir);
	}
	else if (target == 1) {
		if (v[0].at(2) != v[1].at(6)) {
			rotate(0, -dir);
		}

		if (v[1].at(2) != v[2].at(6)) {
			if (v[2].at(2) != v[3].at(6)) {
				rotate(3, dir);
			}
			rotate(2, -dir);
		}
		rotate(1, dir);
	}
	else if (target == 2) {
		if (v[2].at(2) != v[3].at(6)) {
			rotate(3, -dir);
		}

		if (v[1].at(2) != v[2].at(6)) {
			if (v[0].at(2) != v[1].at(6)) {
				rotate(0, dir);
			}
			rotate(1, -dir);
		}
		rotate(2, dir);
	}
	else if (target == 3) {
		if (v[2].at(2) != v[3].at(6)) {
			if (v[1].at(2) != v[2].at(6)) {
				if (v[0].at(2) != v[1].at(6)) {
					rotate(0, -dir);
				}
				rotate(1, dir);
			}
			rotate(2, -dir);
		}
		rotate(3, dir);
	}
}

void rotate(int target, int direction) {
	if(direction == 1) {
		int tmp = v[target].at(v[target].size() - 1);
		v[target].pop_back();
		v[target].insert(v[target].begin(), tmp);
	}

	// 반시계방향
	if (direction == -1) {
		int tmp = v[target].at(0);
		v[target].erase(v[target].begin());
		v[target].push_back(tmp);
	}
}