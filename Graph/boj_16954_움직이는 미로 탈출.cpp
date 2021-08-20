//https://www.acmicpc.net/problem/16954
#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <set>

using namespace std;
char graph[8][8];
int dir[9][2] = { {0,0}, {1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,-1},{1,1},{-1,1} };
vector <pair<int, int>> block;
void bfs() {
	
	queue<pair<int, int>> q;
	q.push({ 7,0 });

	while (!q.empty()) {
		int size = q.size();
		set<pair<int, int>> se;
		for (int i = 0; i < block.size(); i++) {
			if (block[i].first <= 7) {
				se.insert({ block[i].first,block[i].second });
				se.insert({ ++block[i].first,block[i].second });
			}
		}
		while(size--) {
			int r = q.front().first;
			int c = q.front().second;
			if (r == 0 && c == 7||se.empty()) {
				cout << 1;
				return;
			}
			q.pop();
			for (int i = 0; i < 9; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];
				if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
					if (se.find({ nr,nc }) != se.end()) {
						continue;
					}
					q.push({ nr,nc });
				}
			}
		}
	}
	cout << 0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			cin >> graph[i][j];
			if (graph[i][j] == '#') {
				block.push_back({ i,j });
			}
		}
	}

	bfs();
	return 0;
}
