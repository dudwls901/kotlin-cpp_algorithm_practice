//https://www.acmicpc.net/problem/17144
#include <iostream>
#include <vector>
using namespace std;

//6<=r,c<=50
//1<=t<=1000
int R, C, T;
int graph[50][50];
int moving[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
vector<int> freshAir;
//1초마다 확산->공청 (퍼트리기, 돌리기)

bool isInside(int r, int c) {
	if (r < 0 || r >= R || c < 0 || c >= C) return false;
	return true;
}

void increase() {
	int originVal[50][50];
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			originVal[i][j] = graph[i][j];
		}
	}
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (graph[i][j] > 0) {				
				int minusCnt = 0;
				for (int dir = 0; dir < 4; dir++) {
					int nR = i + moving[dir][0];
					int nC = j + moving[dir][1];
					if (isInside(nR, nC)) {
						if (graph[nR][nC] == -1) continue;
						graph[nR][nC] += originVal[i][j] / 5;
						minusCnt++;
					}
				}
				graph[i][j] -= originVal[i][j]/5 * minusCnt;
			}
		}
	}
}

void rotate() {
	int uR = freshAir[0];
	int uC = 1;
	int pre = 0;
	while (!(uR == freshAir[0] && uC == 0)) {

		int temp = graph[uR][uC];
		graph[uR][uC] = pre;
		pre = temp;
		if (uR == freshAir[0]) {
			if (uC == C - 1) {
				uR--;
			}
			else {
				uC++;
			}
		}
		else if (uR == 0) {
			if(uC==0){
				uR++;
			}
			else {
				uC--;
			}
		}
		else if (uC == 0) {
			if (uR == freshAir[0]) {
				uC++;
			}
			else {
				uR++;
			}
		}
		else if (uC == C - 1) {
			if (uR == 0) {
				uC--;
			}
			else {
				uR--;
			}
		}
	}
	int dR = freshAir[1];
	int dC = 1;
	pre = 0;
	while (!(dR == freshAir[1] && dC == 0)) {
		int temp = graph[dR][dC];
		graph[dR][dC] = pre;
		pre = temp;
		if (dR == freshAir[1]) {
			if (dC == C - 1) {
				dR++;
			}
			else {
				dC++;
			}
		}
		else if (dR == R-1) {
			if (dC == 0) {
				dR--;
			}
			else {
				dC--;
			}
		}
		else if (dC == 0) {
			if (dR == freshAir[1]) {
				dC++;
			}
			else {
				dR--;
			}
		}
		else if (dC == C - 1) {
			if (dR == R-1) {
				dC--;
			}
			else {
				dR++;
			}
		}
	}
	graph[freshAir[0]][0] = graph[freshAir[1]][0] = -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> R >> C >> T;
	
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> graph[i][j];
			if (graph[i][j] == -1) {
				freshAir.push_back({ i });
			}
		}
	}

	while (T--) {
		increase();
		rotate();
	}
	int answer = 2;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			answer += graph[i][j];
		}
	}
	cout << answer;

	return 0;
}
