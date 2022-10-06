#include <iostream>
#include <algorithm>
#include <cstring>
#include <math.h>
#include <queue>

using namespace std;

struct pos {
	int row;
	int col;
};

pos home;
pos pentaport;
pos shop[100];
int shop_cnt;
bool visited[100] = { false, };

int beer;

bool dist(pos a, pos b);
void BFS(pos start);

int main() {
	int T;

	// test case
	cin >> T;
	for (int tc = 0; tc < T; tc++) {
		beer = 20;
		memset(visited, false, sizeof(visited));

		int tmp_row, tmp_col;

		cin >> shop_cnt;
		cin >> tmp_row >> tmp_col;
		home.row = tmp_row;
		home.col = tmp_col;
		for (int i = 0; i < shop_cnt; i++) {
			cin >> tmp_row >> tmp_col;
			shop[i].row = tmp_row;
			shop[i].col = tmp_col;
		}
		cin >> tmp_row >> tmp_col;
		pentaport.row = tmp_row;
		pentaport.col = tmp_col;

		BFS(home);
	}

	// normal end
	return 0;
}

void BFS(pos start) {
	queue<pos> q;
	q.push(start);

	while (!q.empty()) {
		pos cur = q.front();
		q.pop();

		//cout << cur.row << " " << cur.col << '\n';

		if (dist(cur, pentaport)) {
			cout << "happy" << '\n';
			return;
		}

		for (int i = 0; i < shop_cnt; i++) {
			//cout << i << '\n';
			if (dist(cur, shop[i]) && !visited[i]) {
				q.push(shop[i]);
				visited[i] = true;
			}
		}
	}

	cout << "sad" << '\n';
}

bool dist(pos a, pos b) {
	int row = abs(a.row - b.row);
	int col = abs(a.col - b.col);

	//cout << row + col << '\n';

	if (row + col <= 1000) {
		return true;
	}

	//cout << "false" << '\n';
	return false;
}