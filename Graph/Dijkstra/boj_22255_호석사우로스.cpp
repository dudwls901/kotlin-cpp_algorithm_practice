//https://www.acmicpc.net/problem/22255
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

//1<=n,m<=100
//-1<=충격량<=300
int n, m;
int sR, sC, eR, eC;
int graph[101][101];
int visited[3][101][101];
pair<int,int> dir[3][4];
struct nodeInfo {
	int  r, c, cnt,damage;
};

struct cmp {
	bool operator()(nodeInfo &a, nodeInfo &b) {
		return a.damage > b.damage;
	}
};

bool isInside(int r,int c) {
	if (r < 1 || r > n || c < 1 || c > m) return false;
	return true;
}

int dijkstra() {
	priority_queue<nodeInfo,vector<nodeInfo>,cmp> pq;
	pq.push({ sR,sC,1,0 });
	int answer = 987654321;
	while (!pq.empty()) {
		int r = pq.top().r;
		int c = pq.top().c;
		int cnt = pq.top().cnt;
		int damage = pq.top().damage;
		pq.pop();
		
		if (visited[cnt % 3][r][c] < damage) continue;
		if (r == eR && c == eC) {
			answer = min(answer, damage);
			break;
		}
		int range = 0;
		if (cnt % 3 == 0) {
			range = 4;
		}
		else {
			range = 2;
		}
;		for (int i = 0; i < range; i++) {
			int nR = r + dir[cnt % 3][i].first;
			int nC = c + dir[cnt % 3][i].second;
			if (!isInside(nR, nC))continue;
			if (graph[nR][nC] == -1) continue;
			if (visited[(cnt+1) % 3][nR][nC] > damage + graph[nR][nC]) {
				visited[(cnt+1) % 3][nR][nC] = damage + graph[nR][nC];
				pq.push({ nR,nC,cnt + 1,damage + graph[nR][nC] });
			}
		}

	}
	if (answer == 987654321) {
		return -1;
	}
	return answer;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	cin >> sR >> sC >> eR >> eC;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> graph[i][j];
		}
	}
	dir[0][0] = { 0,1 };
	dir[0][1] = { 1,0 };
	dir[0][2] = { 0,-1 };
	dir[0][3] = { -1,0 };
	dir[1][0] = { 1 , 0 };
	dir[1][1] = { -1, 0 };
	dir[2][0] = { 0,1 };
	dir[2][1] = { 0,-1 };
	for (int i = 0; i < 3; i++) {
		for (int j = 1; j <= 100; j++) {
			for (int k = 1; k <= 100; k++) {
				visited[i][j][k] = 987654321;
			}
		}
	}
	cout << dijkstra();

	return 0;
}
