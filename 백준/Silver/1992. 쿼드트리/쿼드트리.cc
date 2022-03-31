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

int N;
string arr[64];

void division(int size, int y, int x)
{
    char curr = arr[y][x];

    for (int i = y; i < y + size; i++)
        for (int j = x; j < x + size; j++)
            if (arr[i][j] != curr)
            {
                cout << '(';
                division(size / 2, y, x);
                division(size / 2, y, x + size / 2);
                division(size / 2, y + size / 2, x);
                division(size / 2, y + size / 2, x + size / 2);
                cout << ')';
                return;
            }

    cout << curr;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;
    for (int i = 0; i < N; i++)
        cin >> arr[i];

	division(N, 0, 0);
}



