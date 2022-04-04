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

int n, m;
bool check[101][101]; 
int mmap[101][101];
int length[100][100];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
queue<pair<int, int>> q;

void BFS(int x, int y) {
    q.push(make_pair(y, x));
    //length[y][x] = 1;
    check[y][x] = true;

    while (!q.empty()) {
        int x = q.front().second;
        int y = q.front().first;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i]; 
            int next_y = y + dy[i];

            if (next_x >= 0 && next_y >= 0 && next_x < m && next_y < n && mmap[next_y][next_x] == 1 && check[next_y][next_x] == false) {
                length[next_y][next_x] = length[y][x] + 1;
                check[next_y][next_x] = true;
                q.push(make_pair(next_y, next_x));
            }
        }
    }
}

int main(void) {
        ios_base::sync_with_stdio(false);
	    cin.tie(NULL);
	    cout.tie(NULL);
        scanf("%d %d", &n, &m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                scanf("%1d", &mmap[i][j]);
            }
        }
        
        BFS(0, 0);
    
        cout << length[n - 1][m - 1] + 1 << '\n';
}
