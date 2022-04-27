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

int T, N;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> T;
	for (int test = 0; test < T; test++) {
		int arr[100000][2];
		int dp[100000][2];;

		cin >> N;
		for (int i = 0; i < N; i++) {
			cin >> arr[i][0];
		}
		for (int i = 0; i < N; i++) {
			cin >> arr[i][1];
		}
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[1][0] = arr[0][1] + arr[1][0];
		dp[1][1] = arr[0][0] + arr[1][1];

		for (int i = 2; i < N; i++) {
			dp[i][0] = max(dp[i - 1][1], dp[i - 2][1]) + arr[i][0];
			dp[i][1] = max(dp[i - 1][0], dp[i - 2][0]) + arr[i][1];
		}
		
		int result = max(dp[N - 1][0], dp[N - 1][1]);

		cout << result << '\n';
	}
}