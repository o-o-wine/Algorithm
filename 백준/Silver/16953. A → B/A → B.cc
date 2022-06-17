#define _CRT_SECURE_NO_WARNINGS
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

// Value
long long N, A, B;

// Matrix direction
//int dx[4] = { 0, 0, 1, -1 };
//int dy[4] = { 1, -1, 0, 0 };

// Sturct
//struct st {
//};

int BFS() {
	long long result = 0x7f7f7f7f;

	queue<pair<long long, long long>> q;
	q.push({ A, 0 });

	while (!q.empty()) {
		long long num = q.front().first;
		long long cnt = q.front().second;
		q.pop();

		if (num == B) {
			result = min(result, cnt);
			return result + 1;
		}

		if ((num * 10 + 1) <= B) {
			q.push({ (num * 10 + 1), cnt + 1 });
		}

		if ((num * 2) <= B) {
			q.push({ (num * 2), cnt + 1 });
		}
	}

	if (result == 0x7f7f7f7f)
		return -1;
}

// Main function
int main() {
	// cin, cout
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// BOJ Format
	cin >> A >> B;
	N = BFS();

	cout << N << '\n';

	return 0;
}