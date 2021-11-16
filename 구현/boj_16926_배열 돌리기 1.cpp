//https://www.acmicpc.net/problem/16926
#include <iostream>
#include <algorithm>
using namespace std;

//2<=n,m<=300
//1<=t<=1000
//min(n,m)mod2=0
//1<=aij<=10^8
int n, m, t;
int graph[300][300];

void dfs(int t) {
	if (t == 0) return;
	int depth = min(n, m) / 2 + min(n, m) % 2;
	for (int start = 0; start < depth; start++) {
		int r = start;
		int c = start;
		int pre =graph[r][c];
		//왼쪽
		while (r < n - 1 - start) {
			int nextVal = graph[r + 1][c];
			graph[r + 1][c] = pre;
			pre = nextVal;
			r++;
		}
		//바닥
		while (c < m-1-start) {
			int nextVal = graph[r][c + 1];
			graph[r][c + 1] = pre;
			pre = nextVal;
			c++;
		}
		//오른쪽
		while (r>=1+start) {
			int nextVal = graph[r - 1][c];
			graph[r - 1][c] = pre;
			pre = nextVal;
			r--;
		}
		//위
		while (c>=1+start) {
			int nextVal = graph[r][c - 1];
			graph[r][c - 1] = pre;
			pre = nextVal;
			c--;
		}
	}
	dfs(t - 1);

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> t;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> graph[i][j];
		}
	}
	dfs(t);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << graph[i][j]<<' ';
		}
		cout << '\n';
	}
	return 0;
}
