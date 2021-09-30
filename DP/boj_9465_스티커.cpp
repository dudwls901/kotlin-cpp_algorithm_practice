//https://www.acmicpc.net/problem/9465
#include <iostream>
#include <algorithm>
#define MAX 100001

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		int dp[2][MAX];
		dp[0][0] = dp[1][0] = 0;
		for (int i = 1; i <= n; i++) {
			cin >> dp[0][i];
		}
		for (int i = 1; i <= n; i++) {
			cin >> dp[1][i];
		}
		
		for (int i = 2; i <= n; i++) {
			dp[0][i] = max(dp[1][i-1],dp[1][i-2])+dp[0][i];
			dp[1][i] = max(dp[0][i - 1], dp[0][i-2])+ dp[1][i];
		}
		int answer = max(dp[1][n], dp[0][n]);
		cout << answer << '\n';
	}
	


	return 0;
}
