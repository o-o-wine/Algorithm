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

// Test_case
int T, test_case;

// Value
int N;

// Matrix direction
//int dx[4] = { 0, 0, 1, -1 };
//int dy[4] = { 1, -1, 0, 0 };

// Sturct
//struct st {
//};

// Main function
int main() {
	// cin, cout
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	// SWEA 양식
	// T = 10;
	cin >> T;
	for (test_case = 1; test_case <= T; test_case++) {
		int ans = 0;
		string str = "";
		string buf = "";

		cin >> str;
		buf += str[0];

		for (int i = 1; str.size(); i++) {
			if (buf == str.substr(buf.size(), i)) {
				ans = i;
				break;
			}
			else {
				buf += str[i];
			}
		}

		cout << "#" << test_case << " " << ans << '\n';
	}
	
	return 0;
}