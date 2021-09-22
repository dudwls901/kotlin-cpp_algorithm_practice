//https://www.acmicpc.net/problem/15988
#include <iostream>

#define MAX 1000001
#define MOD 1000000009
using namespace std;
long long dp[MAX] = { 0,1,2,4 };
int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int t;
	cin >> t;
	
	int dpIdx = 4;
	for (int i = 0; i < t; i++) {
		int n;
		cin >> n;
		
		for (int j = dpIdx; j <= n; j++) {
			dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % MOD;
			dpIdx++;
		}
		cout << dp[n] << '\n';
	}


	return 0;
}
