#include <iostream>
#include <string>
#include <stack>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;


int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int swp, n, check;
	queue<int> q;

	cin >> n;
	if (n >= 1 && n <= 500000) {
		// 삽입
		for(int i = 1; i <= n; i++)
			q.push(i);
		// 삭제 추가
		while (q.size() > 1) {
			q.pop();
			q.push(q.front());
			q.pop();
		}

		cout << q.front();
	}
}