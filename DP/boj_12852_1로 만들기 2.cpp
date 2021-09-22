//https://www.acmicpc.net/problem/12852
#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	vector<int> dp(n+1);
	vector<int> before(n + 1);
	before[1] = 1;
	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1]+1;
		before[i] = i - 1;
		if (i % 3 == 0) {
			if (dp[i] > dp[i / 3] + 1) {
				dp[i] = dp[i / 3] + 1;
				before[i] = i / 3;
			}
		}
		if (i % 2 == 0) {
			if (dp[i] > dp[i / 2] + 1) {
				dp[i] = dp[i / 2] + 1;
				before[i] = i / 2;
			}
		}
		
	}
	cout << dp[n]<<'\n';
	if(n!=0)
		cout << n << ' ';
	while (n != 1) {
		n = before[n];
		cout << n << ' ';
	}
	return 0;
}
