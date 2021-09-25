//https://www.acmicpc.net/problem/21278
#include <iostream>
#include <algorithm>
#include <tuple>

#define MAX 101
#define INF 987654321
using namespace std;
int n, m;
int graph[MAX];
//플로이드 or bfs 2개 시작 점
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	//2<=n<=100
	
	cin >> n >> m;
	int dp[MAX][MAX];
	for (int i = 0; i <= n; i++) {
		for (int j = 0; j <= n; j++) {
			if (i == j) {
				dp[i][j] = 0;
			}
			else {
				dp[i][j] = INF;
			}
		}
	}

	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;
		dp[from][to] = 1;
		dp[to][from] = 1;
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
			}
		}
	}
	tuple<int, int, int> answer = make_tuple( INF ,INF,INF);
	for (int i = 1; i <= n; i++) {
		for (int j = i+1; j <= n; j++) {
			int sum = 0;
			for (int k = 1; k <= n; k++) {
				sum += min(dp[i][k], dp[j][k]);
			}
			if (sum < get<2>(answer)) {
				answer = make_tuple(i, j, sum);
			}
		}
	}
	cout << get<0>(answer) << ' ' << get<1>(answer) << ' ' << get<2>(answer) * 2;
	return 0;
}
