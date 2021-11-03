//https://www.acmicpc.net/problem/14462
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
//1<=n<=1000
int n;
int arr1[1001],arr2[1001];
int dp[1001][1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr1[i];
	}
	for (int i = 1; i <= n; i++) {
		cin >> arr2[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			if (abs(arr1[i] - arr2[j]) <= 4) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
		}
	}
	cout << dp[n][n];
	return 0;
}
