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
char arr[26][2];

void preorder(char c) {
	if (c == '.')
		return;

	cout << c;
	preorder(arr[c - 65][0]);
	preorder(arr[c - 65][1]);
}

void inorder(char c) {
	if (c == '.')
		return;

	inorder(arr[c - 65][0]);
	cout << c;
	inorder(arr[c - 65][1]);
}

void postorder(char c) {
	if (c == '.')
		return;

	postorder(arr[c - 65][0]);
	postorder(arr[c - 65][1]);
	cout << c;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++) {
		char input;
		cin >> input;
		cin >> arr[input - 65][0] >> arr[input - 65][1];
	}

	preorder('A');
	cout << '\n';
	inorder('A');
	cout << '\n';
	postorder('A');
	cout << '\n';
}