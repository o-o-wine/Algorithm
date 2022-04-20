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

int N;
int arr[1001][3];
int dp[1001][3];

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i][0];
		cin >> arr[i][1];
		cin >> arr[i][2];
	}
	
	dp[0][0] = arr[0][0];
	dp[0][1] = arr[0][1];
	dp[0][2] = arr[0][2];

	for (int i = 1; i < N; i++) {
		dp[i][0] = arr[i][0] + min(dp[i-1][1], dp[i - 1][2]);
		dp[i][1] = arr[i][1] + min(dp[i-1][2], dp[i - 1][0]);
		dp[i][2] = arr[i][2] + min(dp[i-1][1], dp[i - 1][0]);
	}

	cout << min(min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]) << '\n';
}

