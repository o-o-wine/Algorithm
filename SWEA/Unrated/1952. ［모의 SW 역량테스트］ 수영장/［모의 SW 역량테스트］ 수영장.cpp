#include <iostream>
#include <algorithm>
#include <string>

#define DAY 0
#define MONTH 1
#define QUARTER 2
#define YEAR 3

using namespace std;

int T;

int mon[12] = { 0, };
int cost[4] = { 0, };

int answer;

// Brute-Force DFS
void DFS(int cnt, int sum);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		answer = 1e9;

		cin >> cost[DAY] >> cost[MONTH] >> cost[QUARTER] >> cost[YEAR];

		for (int i = 0; i < 12; i++) {
			cin >> mon[i];
		}

		DFS(0, 0);

		cout << "#" << tc << " " << answer << '\n';
	}
	
	return 0;
}

void DFS(int cnt, int sum) {
	// Termination condition
	if (cnt > 11) {
		answer = min(sum, answer);
		return;
	}

	// if year
	if (cnt == 0) {
		DFS(cnt + 12, sum + cost[YEAR]);
	}

	// if day 
	DFS(cnt + 1, sum + (mon[cnt] * cost[DAY]));
	// if month
	DFS(cnt + 1, sum + cost[MONTH]);
	// if year
	DFS(cnt + 3, sum + cost[QUARTER]);
}