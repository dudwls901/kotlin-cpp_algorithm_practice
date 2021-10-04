//https://www.acmicpc.net/problem/2167
#include <iostream>

#define MAX 301
using namespace std;

long long pSum[MAX][MAX];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n,m;
	cin >> n>>m;
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> pSum[i][j];
			pSum[i][j] += pSum[i][j-1] +pSum[i-1][j]-pSum[i-1][j-1];
		}
	}
	int k;
	cin >> k;
	
	for (int i = 0; i < k; i++) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		cout << pSum[c][d] - pSum[a - 1][d] - pSum[c][b - 1] + pSum[a - 1][b - 1]<<'\n';
	}

	return 0;
}
