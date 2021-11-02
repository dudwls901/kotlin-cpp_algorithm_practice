//https://www.acmicpc.net/problem/14500
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//4<=n,m<=400
int n, m;
int graph[500][500];
int dir[4][2] = { {0,1} ,{0,-1},{1,0},{-1,0} };
bool visited[500][500];
int answer;

bool isInside(int r, int c) {
	if (r < 0 || r >= n || c < 0 || c >= m) return false;
	return true;
}

void reset() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visited[i][j] = false;
		}
	}
}

void dfs(int r, int c, int depth, int sum) {
	if (depth == 3) {
		answer = max(answer, sum);
		return;
	}

	for (int i = 0; i < 4; i++) {
		int nR = r + dir[i][0];
		int nC = c + dir[i][1];
		if (!isInside(nR, nC))continue;
		if (visited[nR][nC])continue;
		visited[nR][nC] = true;
		dfs(nR, nC, depth + 1, sum + graph[nR][nC]);
		visited[nR][nC] = false;
	}
}

void shape1(int r, int c)
{
	int sum = 0;
	sum = graph[r][c] + graph[r][c + 1] + graph[r][c + 2] + graph[r - 1][c + 1];
	answer = max(answer, sum);
}

void shape2(int r, int c)
{
	int sum = 0;
	sum = graph[r][c] + graph[r][c + 1] + graph[r][c + 2] + graph[r + 1][c + 1];
	answer = max(answer, sum);
}

void shape3(int r, int c)
{
	int sum = 0;
	sum = graph[r][c] + graph[r + 1][c] + graph[r + 2][c] + graph[r + 1][c + 1];
	answer = max(answer, sum);
}

void shape4(int r, int c)
{
	int sum = 0;
	sum = graph[r][c] + graph[r - 1][c + 1] + graph[r][c + 1] + graph[r + 1][c + 1];
	answer = max(answer, sum);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	answer = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> graph[i][j];
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visited[i][j] = true;
			dfs(i, j, 0, graph[i][j]);
			visited[i][j] = false;
			if (i - 1 >= 0 && j + 2 < m) shape1(i, j);
			if (j + 2 < m && i + 1 < n) shape2(i, j);
			if (i + 2 < n && j + 1 < m) shape3(i, j);
			if (i + 1 < n && i - 1 >= 0 && j + 1 < m) shape4(i, j);
		}
	}

	cout << answer;

	return 0;
}
