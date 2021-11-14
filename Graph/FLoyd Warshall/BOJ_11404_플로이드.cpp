//https://www.acmicpc.net/problem/11404
#include <iostream>
#include <algorithm>
#define INF 987654321
using namespace std;

int n;
int dp[101][101];
//2<=n<=100
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	int m;
	cin >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j)
				dp[i][j] = 0;
			else
				dp[i][j] = INF;
		}
	}
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		dp[from][to] = min(dp[from][to],cost);
	}
	for (int k = 1; k <=n; k++) {
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			//갈 수 없는 경우 0을 출력
			if (dp[i][j] == INF) {
				cout << 0 << ' ';
				continue;
			}
			cout << dp[i][j] << ' ';
		}
		cout << '\n';
	}
	return 0;
}
