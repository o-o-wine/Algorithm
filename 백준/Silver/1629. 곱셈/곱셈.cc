#define _CRT_SECURE_NO_WARNINGS
// 헤더파일
#define ll long long int
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
ll A, B, C;

ll mul(ll A, ll B, ll C) {
	if (B == 1)
		return A;
	else {
		ll temp = mul(A, B / 2, C);

		if (B % 2) {
			return ((temp * temp) % C * A) % C;
		}
		else
			return (temp * temp) % C;
	}
}

int main() { 
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> A >> B >> C;

	cout << mul(A % C, B, C) << '\n';
}