//https://www.acmicpc.net/problem/11057
#include <iostream>

using namespace std;
//1<=n<=1000
//dp
long long dp[1001][10];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;

	for (int i = 0; i < 10; i++) {
		dp[1][i] = 1;
	}
	for (int i = 2; i <= n; i++) {
		long long answer = 0;
		for (int j = 0; j < 10; j++) {
			for (int k = j; k < 10; k++) {
				dp[i][j] += dp[i - 1][k];
				dp[i][j] %= 10007;
			}
			if (i == n) {
				answer += dp[i][j];
			}
		}
		if (i == n) {
			cout << answer%10007;
			return 0;
		}
	}
	cout << 10;
	return 0;
}
