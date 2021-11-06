//https://www.acmicpc.net/problem/11403
#include <iostream>
using namespace std;

int n;
bool edge[100][100];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> edge[i][j];
		}
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (edge[i][k] && edge[k][j]) {
					edge[i][j] = true;
				}
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << edge[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}
