//https://www.acmicpc.net/problem/14620
#include <iostream>
#include <algorithm>
using namespace std;

int n;
//6<=n<=10
int graph[10][10];
int dir[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
bool visited[10][10];
int result = 987654321;

void resetDir(int r, int c) {
	visited[r][c] = false;

	for (int i = 0; i < 4; i++) {
		int nR = r + dir[i][0];
		int nC = c + dir[i][1];
		visited[nR][nC] = false;	
	}
}

int sumDir(int r, int c) {
	//꽃이 죽는 경우는 visited를 건들지 않는다.
	for (int i = 0; i < 4; i++) {
		int nR = r + dir[i][0];
		int nC = c + dir[i][1];
		if (visited[nR][nC]) {
			return -1;
		}	
	}
	//꽃이 죽지 않는 경우 visited true 체크해주고 sum return
	int sum = graph[r][c];
	for (int i = 0; i < 4; i++) {
		int nR = r + dir[i][0];
		int nC = c + dir[i][1];
		visited[nR][nC] = true;
		sum += graph[nR][nC];
	}
	return sum;
}

void dfs(int r,int c, int cnt,int cost) {
	if (cnt == 3) {
		result = min(result, cost);
		return;
	}
	for (int i = r; i < n - 1; i++) {
		for (int j = 1; j < n - 1; j++) {
			if (visited[i][j])continue;
			int sum = sumDir(i, j);
			//꽃이 죽지 않으면 다음 꽃 찾기
			if(sum!=-1) {
				dfs(i, j, cnt + 1, cost + sum);
				resetDir(i, j);
			}
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> graph[i][j];
		}
	}

	
	for (int i = 1; i < n - 1; i++) {
		for (int j = 1; j < n - 1; j++) {
			int sum= sumDir(i, j);
			dfs(i, j, 1, sum);
			resetDir(i, j);
		}
	}
	cout << result;

	return 0;
}
