#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

// value
int N, D, K, C;
int map[30000];
bool check[3001];
int answer = 0;

// main function
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	// input
	cin >> N >> D >> K >> C;
	for (int i = 0; i < N; i++) {
		cin >> map[i];
	}

	for (int i = 0; i < N; i++) {
		int cmp = K;
		int event = 1;

		for (int j = i; j < i + K; j++) {
			int idx = j % N;
			
			if (check[map[idx]])
				cmp--;
			else
				check[map[idx]] = true;

			if (map[idx] == C)
				event = 0;
		}
		cmp += event;
		memset(check, false, sizeof(check));
		answer = max(answer, cmp);
	}

	cout << answer << '\n';

	// end
	return 0;
}