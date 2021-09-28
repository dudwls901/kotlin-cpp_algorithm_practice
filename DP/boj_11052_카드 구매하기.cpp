https://www.acmicpc.net/problem/11052
#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;
int dp[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	//1<=n<=1000
	//1<=pi<=10000
	int n;
	cin >> n;
	cin >> dp[1];
	for (int i = 2; i <= n; i++) {
		cin >> dp[i];
		for (int j = 1; j < i; j++) {
			dp[i] = max(dp[i], dp[j] + dp[i - j]);
		}
	}
	cout << dp[n];

	return 0;
}
