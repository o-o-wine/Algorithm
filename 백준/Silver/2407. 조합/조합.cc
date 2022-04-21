// 헤더파일
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

int N, M;
string arr[101][101];

string b_add(string s1, string s2) {
	int sum = 0;
	string r;

	while (!s1.empty() || !s2.empty() || sum) {
		if(!s1.empty()) {
			sum += s1.back() - '0';
			s1.pop_back();
		}
		if (!s2.empty()) {
			sum += s2.back() - '0';
			s2.pop_back();
		}
		
		r.push_back((sum % 10) + '0');
		sum /= 10;
	}

	reverse(r.begin(), r.end());
	//cout << r << '\n';
	return r;
}

void comb() {
	for (int i = 2; i <= N; i++) {
		for (int j = 0; j <= M; j++) {
			if (i == j || j == 0)
				arr[i][j] = "1";
			else
				arr[i][j] = b_add(arr[i - 1][j - 1], arr[i - 1][j]);
		}
	}
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	arr[0][0] = "1";  arr[1][0] = "1"; arr[1][1] = "1";
	comb();
	cout << arr[N][M];
}
