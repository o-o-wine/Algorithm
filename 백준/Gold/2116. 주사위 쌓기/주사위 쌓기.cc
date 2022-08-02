#include <iostream>
#include <algorithm>

using namespace std;

int N, ans = 0;
int arr[10000][6];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2] >> arr[i][4] >> arr[i][5] >> arr[i][3];
	}

	for (int i = 0; i < 6; i++) { 
		int bot = i, cnt = 0, res = 0;

		while (cnt < N) {
			int val = 0;
			for (int j = 0; j < 6; j++) {
				if ((j != bot && j != (bot + 3) % 6) && val < arr[cnt][j])
					val = arr[cnt][j];
			}
			res += val;

			if (cnt < N - 1) {
				int up = arr[cnt][(bot + 3) % 6];

				for (int j = 0; j < 6; j++) {
					if (up == arr[cnt + 1][j]) {
						bot = j;
						break;
					}
				}
			}
			cnt++;
		}
		ans = max(ans, res);
	}

	cout << ans;

	return 0;
}