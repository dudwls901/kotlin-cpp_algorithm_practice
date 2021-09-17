//https://www.acmicpc.net/problem/21922
#include <iostream>
#include <vector>
#include <queue>

#define MAX 2000	
using namespace std;
int n, m;
int graph[MAX][MAX];
bool visited[4][MAX][MAX];
queue<pair<pair<int, int>, int>> q;
int answer[MAX][MAX];
//1<= n<=2000 1<=m<=2000 n!=m
//에어컨 0~50개

//상우하좌
int mov[4][2] = { {-1,0}, {0,1},{1,0} ,{0,-1} };

void bfs() {
	
	while (!q.empty()) {
		int dir = q.front().second;
		int nR = q.front().first.first+mov[dir][0];
		int nC = q.front().first.second+mov[dir][1];
		q.pop();
		if (nR < 0 || nR >= n || nC < 0 || nC >= m) continue;
		if (visited[dir][nR][nC]) continue;
		visited[dir][nR][nC] = true;
		answer[nR][nC] = 1;
		if (graph[nR][nC] == 1 && dir % 2 == 1)continue;
		else if (graph[nR][nC] == 2 && dir % 2 == 0)continue;
		else if (graph[nR][nC] == 9)continue;
		else if (graph[nR][nC] == 3) {
			if (dir < 2) {
				dir = (dir + 1) % 2;
			}
			else {
				dir = 2 + (dir + 1) % 2;
			}
		}
		else if (graph[nR][nC] == 4) {
			if (dir == 0) dir = 3;
			else if (dir == 3) dir = 0;
			else if (dir == 1) dir = 2;
			else dir = 1;
		}
		q.push({ {nR,nC},dir });
	}


}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >>graph[i][j];
			if (graph[i][j] == 9) {
				answer[i][j]=1;
				for (int k = 0; k < 4; k++) {
					visited[k][i][j] = true;
					q.push({ {i,j},k });
				}
			}
		}
	}
	bfs();
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			sum+=answer[i][j];
		}
	}
	cout << sum;
}
