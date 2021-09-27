//https://www.acmicpc.net/problem/17626
#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;

int dp[50001];
void makeDp(int num) {
	
	for (int i = 1; i*i <= num; i++) {
		if (dp[num] == 0) {
			dp[num] = dp[i*i] + dp[num - i*i];
		}
		else {
			dp[num] = min(dp[num], dp[i*i] + dp[num - i*i]);
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	int size = sqrt(n);
	for (int i = 1; i*i <= n; i++) {
		dp[i*i] = 1;
	}
	for (int i = 1; i <= n; i++) {
		if (dp[i] != 0) continue;
		makeDp(i);
	}
	cout << dp[n];
	return 0;
}
