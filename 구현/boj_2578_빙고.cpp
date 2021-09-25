//https://www.acmicpc.net/problem/2578
#include <iostream>

using namespace std;
int arr[5][5];
pair<int, int> num[26];

bool check() {
	int bingo = 0;
	int crossR = 0;
	int crossL = 0;
	for (int i = 0; i < 5; i++) {
		int col = 0;
		int row = 0;
		for (int j = 0; j < 5; j++) {
			if (arr[i][j] == 0) {
				row++;
			}
			if (arr[j][i] == 0) {
				col++;
			}
		}
		if (col == 5) {
			bingo++;
		}
		if (row == 5) {
			bingo++;
		}
		if (arr[i][i] == 0) {
			crossR++;
		}
		if (arr[i][4-i] == 0) {
			crossL++;
		}
	}
	if (crossR == 5) {
		bingo++;
	}
	if (crossL == 5) {
		bingo++;
	}
	if (bingo >= 3) {
		return true;
	}
	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			cin >> arr[i][j];
			num[arr[i][j]] = { i,j };
		}
	}
	int ans = 0;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			ans++;
			int number;
			cin >> number;
			arr[num[number].first][num[number].second] = 0;
			if (i > 1) {
				if (check()) {
					cout << ans;
					return 0;
				}
			}
		}
	}




	return 0;
}
