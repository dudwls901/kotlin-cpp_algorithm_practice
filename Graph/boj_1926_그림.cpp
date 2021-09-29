//https://www.acmicpc.net/problem/1926
#include <iostream>
#include <algorithm>
using namespace std;

//1<= n <=500
//1<= m <=500
int n, m;
char graph[500][500];
int dir[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
int maxWidth;
int visited[500][500];
int width;
void dfs(int r, int c ) {
	visited[r][c] = true;
	width++;
	//cout <<r<<' '<< c<<' '<< cnt << '\n';
	for (int i = 0; i < 4; i++) {
		int nR = r + dir[i][0];
		int nC = c + dir[i][1];
		if (visited[nR][nC]) continue;
		if (nR >= 0 && nR < n && nC >= 0 && nC < m && graph[nR][nC]=='1') {
			dfs(nR, nC);
		}

	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> graph[i][j];
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visited[i][j] && graph[i][j] == '1') {
				cnt++;
				width = 0;
				dfs(i,j);
				maxWidth = max(maxWidth, width);
			}
		}
	}
	cout << cnt << '\n'<< maxWidth;
	return 0;
}
