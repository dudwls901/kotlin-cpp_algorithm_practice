//https://www.acmicpc.net/problem/15486
#include <iostream>
#include <algorithm>
using namespace std;
#define MAX 1500000
//1<=n<=1500000
//1<=t1<=50 , 1<=p1<=1000
int n;
pair<int, int> input[MAX];
int dp[MAX+1];
int answer;
int curMax;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> input[i].first >> input[i].second;
	}
	for (int i = 0; i <= n; i++) {
		curMax = max(curMax, dp[i]);
		if (i + input[i].first > n) continue;
		dp[i + input[i].first] = max(dp[i + input[i].first], curMax + input[i].second);
		answer = max(answer, dp[i + input[i].first]);
	}
	cout << answer<<'\n';
	return 0;
}
