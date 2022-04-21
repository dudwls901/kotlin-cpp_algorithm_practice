//https://www.acmicpc.net/problem/14502
#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

bool visited[8][8];
int dir[4][2] = { {0,1}, {1,0}, {0,-1}, {-1,0} };
int graph_copy[8][8];
int r, c;
int answer = 0;
vector<pair<int,int>> virus;

void bfs(int row, int col) {
	queue<pair<int, int>> q;
	q.push({ row, col });
	
	while (!q.empty()) {
		int now_r = q.front().first;
		int now_c = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int next_r = now_r+dir[i][0];
			int next_c = now_c+dir[i][1];
			if (next_r >= 0 && next_r < r && next_c >= 0 && next_c < c &&graph_copy[next_r][next_c] == 0) {
				q.push({ next_r,next_c });
				graph_copy[next_r][next_c] = 2;
			}
		}
	}

}

void combination(int idx,int start, int end, int graph[][8]){
	if (start ==end) { //세 개의 기둥을 세운 경우
		
		copy(&graph[0][0], &graph[0][0] + 64, &graph_copy[0][0]);
		int count = 0;
		for (int i = 0; i < virus.size(); i++) {
			bfs(virus[i].first, virus[i].second);
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (graph_copy[i][j] == 0) {
					count++;
				}
			}
		}
		answer = max(answer, count);
		return;
	}
	for (int i = idx; i < r*c; i++) {
		if( graph[i / c][i%c] != 0)
			continue;
		graph[i / c][i%c] = 1;
		combination(i,start+1,end,graph);
		graph[i / c][i%c] = 0;
		}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int graph[8][8];
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> graph[i][j];
			if (graph[i][j] == 2)
				virus.push_back({i,j});
		}
	}
	combination(0,0,3,graph);
	cout << answer;
}
