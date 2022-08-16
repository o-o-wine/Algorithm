#include <iostream>
#include <string>
#include <stack>
#include <queue>
#include <deque>
#include <vector>
#include <algorithm>
#include <cmath>
#include <cstdio>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	int df = 0, dt = 0;
	int N = 0;
	int sum = 0;

	cin >> N;

	df = N / 5;

	while (1) {
		if (df < 0) {
			dt = -1;
			df = 0;
			break;
		}
		if ((N - (df * 5)) % 3 == 0) {
			dt = (N - (df * 5)) / 3;
			break;
		}
		df--;
	}
	sum = dt + df;
	cout << sum;
}