//https://www.acmicpc.net/problem/1663
#include <iostream>
#include <string>

using namespace std;

//1<=n<=100
string base[4];
long long dp[101];
long long answer = 0;
long long cnt[101][3];


char solve(long long idx,int depth) {
	if (depth <= 3) {
		return base[depth][idx - 1];
	}

	if (dp[depth - 3] >= idx) {
		return solve(idx, depth - 3);
	}
	else {
		return solve(idx - dp[depth - 3], depth - 2);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t, n;


	cin >> t >> n;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 2;
	base[1] = "X";
	base[2] = "YZ";
	base[3] = "ZX";
	cnt[1][0] = 1;
	cnt[2][1] = cnt[2][2] = 1;
	cnt[3][0] = cnt[3][2] = 1;
	for (int i = 4; i <= n; i++) {
		dp[i] = dp[i - 3] + dp[i - 2];
		for (int j = 0; j < 3; j++) {
			cnt[i][j] = cnt[i - 3][j]+cnt[i-2][j];
		}
	}
	
	if (t == 1) {
		cout << dp[n];
	}
	else if (t == 2) {
		long long k;
		cin >> k;
		//k번째 문자가 무엇인지
		cout << solve(k, n);
	}
	else {
		char ch;
		cin >> ch;
		cout << cnt[n][ch - 'X'];
	}

	return 0;
}
