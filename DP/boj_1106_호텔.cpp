//https://www.acmicpc.net/problem/1106
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//1<=C<=1000
//1<=n<=20
int dp[100001];
int answer = 987654321;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int c, n;
	cin >> c >> n;
	vector<pair<int, int>> vt(n);
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		vt[i] = { a,b };
	}

	for (int i = 1; i <= 100000; i++) {
		for (int j = 0; j < n; j++) {
			//나누어 떨어지는 경우
			if (i%vt[j].first == 0) {
				dp[i] = max(dp[i], (i / vt[j].first)*vt[j].second);
			}
			if (i - vt[j].first >= 0) {
				dp[i] = max(dp[i],dp[i-vt[j].first]+ vt[j].second);
			}
		}
		if (c<=dp[i]) {
			//cout << "Last : " << i << ' ' << dp[i] <<' '<<c<< '\n';
			cout << i;
			return 0;
		}
		//cout << i << ' ' << dp[i] << '\n';
	}

	return 0;
}
