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

int N, sum = 0;
int arr[501][501];
int dp[501][501];

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			cin >> arr[i][j];
			if(i == 0 && j == 0)
				dp[i][j] = arr[i][j];
			if (i != 0) {
				if (j == 0) {
					dp[i][j] = arr[i][j] + dp[i - 1][j];
				}
				else if (j == i) {
					dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
				}
				else {
					dp[i][j] = arr[i][j] + max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
	}

	int max = 0;
	for (int i = 0; i <= N; i++) {
		if (dp[N-1][i] > max)
			max = dp[N-1][i];
	}

	cout << max;
}