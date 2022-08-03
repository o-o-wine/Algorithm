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

using namespace std;

int arr[100001];
int dp[100001];

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(NULL);

	int N, M;

	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}
	dp[1] = arr[1];
	for (int i = 1; i <= N; i++) {
		dp[i] = arr[i] + dp[i - 1];
	}
	for (int i = 0; i < M; i++) {
		int s, e;
		int sum = 0;
		cin >> s >> e;
		
		cout << dp[e] - dp[s-1] << '\n';
	}
}