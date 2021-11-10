//https://www.acmicpc.net/problem/2580
#include <iostream>
using namespace std;

int graph[9][9];
bool finish;
bool xSet[9][10], ySet[9][10], box[9][10];

void backTracking(int cnt) {
	int r = cnt / 9;
	int c = cnt % 9;
	if (cnt==81) {
		finish = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << graph[i][j] << ' ';
			}
			cout << '\n';
		}
		return;
	}
	if (graph[r][c] == 0) {
		for (int k = 1; k <= 9; k++) {
			if (xSet[r][k] || ySet[c][k] || box[(r / 3) * 3 + c / 3][k]) continue;
			graph[r][c] = k;
			xSet[r][k] = true;
			ySet[c][k] = true;
			box[(r / 3) * 3 + c / 3][k] = true;
			backTracking(cnt+1);
			if (finish) return;
			graph[r][c] = 0;
			xSet[r][k] = false;
			ySet[c][k] = false;
			box[(r / 3) * 3 + c / 3][k] = false;
		}
	}
	else {
		backTracking(cnt + 1);
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> graph[i][j];
			xSet[i][graph[i][j]] = true;
			ySet[j][graph[i][j]] = true;
			box[(i / 3) * 3 + j / 3][graph[i][j]] = true;
		}
	}
	backTracking(0);
	return 0;
}
