//https://www.acmicpc.net/problem/13565
#include <iostream>
#include <string>
#define MAX 1000
using namespace std;

//2<=n<=1000
int n, m;
string graph[MAX];
bool canFinish = false;
int dirXY[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
void dfs(int r, int c) {
	graph[r][c] = '2';
	for (int dir = 0; dir < 4; dir++) {
		int nr = r + dirXY[dir][0];
		int nc = c + dirXY[dir][1];
		if(nr==n){
			canFinish = true;
			return;
		}
		if (nr < 0 || nc >= m || nc < 0) continue;
		if (graph[nr][nc] != '0') continue;
		dfs(nr, nc);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> graph[i];
	}
	
	for (int c = 0; c < m; c++) {
		if (graph[0][c] == '0') {
			dfs(0, c);
			if (canFinish == true) {
				cout << "YES";
				return 0;
			}
		}
	}

	cout << "NO";
	return 0;
}
