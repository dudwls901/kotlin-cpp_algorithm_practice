//https://www.acmicpc.net/problem/4963
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int n, m;
//1<=n,m<=50
int dir[8][2] = { {0,1},{1,0},{0,-1},{-1,0} ,{1,1},{-1,-1},{1,-1},{-1,1} };
bool visited[50][50];
void bfs(int i,int j, bool graph[][50]) {
	queue<pair<int, int>>q;
	q.push({ i,j });
	while (!q.empty()) {
		int r = q.front().first;
		int c = q.front().second;
		q.pop();
		for (int i = 0; i < 8; i++) {
			int nR = r + dir[i][0];
			int nC = c + dir[i][1];
			if (nR < 0 || nR >= n || nC < 0 || nC >= m) continue;
			if (visited[nR][nC])continue;
			if (!graph[nR][nC])continue;
			q.push({ nR, nC });
			visited[nR][nC] = true;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	while (true) {
		cin >> m >> n;
		if (n == 0 && m == 0)return 0;
		bool graph[50][50];
		
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cin >> graph[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j]) continue;
				if (!graph[i][j])continue;
				visited[i][j] = true;
				bfs(i,j,graph);
				answer++;
			}
		}
		memset(visited, 0, 2500);
		cout << answer << '\n';
	}


	return 0;
}
