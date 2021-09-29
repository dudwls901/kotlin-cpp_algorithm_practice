//https://www.acmicpc.net/problem/9079
#include <iostream>
#include <queue>
using namespace std;

int graph[3][3];

//행 변환
void moveRow(int row) {
	for (int i = 0; i < 3; i++) {
		graph[row][i] = graph[row][i] ^ 1;
	}
}
//열 변환
void moveCol(int col) {
	for (int i = 0; i < 3; i++) {
		graph[i][col] = graph[i][col] ^ 1;
	}
}

//대각선 변환
void moveCross(int dir) {
	if (dir == 6) {
		for (int i = 0; i < 3; i++) {
			graph[i][i] = graph[i][i] ^ 1;
		}
	}
	else {
		for (int i = 0; i < 3; i++) {
			graph[i][2 - i] = graph[i][2 - i] ^ 1;
		}
	}
}
//그래프의 상태를 10진법으로 저장
int makeBinary() {
	int cur = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			cur = cur * 2 + graph[i][j];
		}
	}
	return cur;
}

//10진법으로 나타낸 상태를 그래프에 갱신
void makeGraph(int cur) {
	for (int i = 2; i >= 0; i--) {
		for (int j = 2; j >= 0; j--) {
			graph[i][j] = cur % 2;
			cur /= 2;
		}
	}
}

//모두 같은 면인지 검사
bool check() {
	int first = graph[0][0];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (first != graph[i][j]) {
				return false;
			}
		}
	}
	return true;
}
//최단 거리(횟수)를 찾기 위한 BFS
int bfs(int cur,bool visited[]) {
	queue<pair<int,int>> q;
	q.push({ cur,0 });
	while (!q.empty()) {
		int cur = q.front().first;
		int cnt = q.front().second;

		q.pop();
		//10진법으로 표현된 그래프의 상태로 그래프를 갱신
		makeGraph(cur);

		//모두 같은 면인지 검사
		if (check()) {
			return cnt;
		}
		//가로,세로,대각 8방향으로 변경
		for (int i = 0; i < 8; i++) {
			//현재 방향으로 변경한 후 다음 방향으로 변경을 위해 원위치
			if (i < 3) {
				moveRow(i);
			}
			else if (i < 6) {
				moveCol(i%3);
			}
			else {
				moveCross(i);
			}
			//다음 그래프의 상태를 10진법으로 변환
			int next = makeBinary();
			//방문하지 않은 상태면 다음 상태와 횟수를 큐에 푸시
			if (!visited[next]) {
				visited[next] = true;
				q.push({ next,cnt + 1 });
			}
			if (i < 3) {
				moveRow(i);
			}
			else if (i < 6) {
				moveCol(i%3);
			}
			else {
				moveCross(i);
			}			
		}
	}

	return -1;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;
	while(t--){
		
		char ch;
		//현재 그래프의 상태를 10진법으로 표현
		int cur = 0;
		bool visited[512] = {0};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cin >> ch;
				graph[i][j] = 0;
				//T는 1 H는 0
				if (ch == 'T') {
					graph[i][j] = 1;
				}
				cur = cur * 2 + graph[i][j];
			}
		}
		visited[cur] = true;
		
		cout << bfs(cur,visited)<<'\n';
		
	}

	return 0;
}
