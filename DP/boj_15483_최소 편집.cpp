//https://www.acmicpc.net/problem/15483
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int dp[1001][1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string from, to;
	cin >> from >> to;
	int maxLen = max(from.length(), to.length());
	for (int i = 1; i <= maxLen; i++) {
		dp[0][i] = i;
		dp[i][0] = i;
	}
	for (int i = 1; i <= to.length(); i++) {
		for (int j = 1; j <= from.length(); j++) {
			if (from[j-1] == to[i-1]) {
				dp[i][j] = dp[i - 1][j - 1];
			}
			else {
				dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}
	}

	cout << dp[to.length()][from.length()];

	return 0;
}
