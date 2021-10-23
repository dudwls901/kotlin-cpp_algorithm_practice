//https://www.acmicpc.net/problem/11265
#include <iostream>
#include <algorithm>
#define MAX 501
using namespace std;


int n, m;
//5<=n<=500
//1<=m<=10000
int dp[MAX][MAX];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> dp[i][j];
		}
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = min(dp[i][k] + dp[k][j], dp[i][j]);
			}
		}
	}
	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		if (dp[a][b] <= c) {
			cout << "Enjoy other party\n";
		}
		else {
			cout << "Stay here\n";
		}
	}


	return 0;
}
