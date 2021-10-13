//https://www.acmicpc.net/problem/18352
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

//2<=n<=300000 노드 개수
//1<=m<=1000000 단방향 간선 개수
//1<=k<=300000 거리
//1<=x<=n 시작점
int n, m, k, x;
vector<int> edge[300001];
bool visited[300001];
void bfs() {
	priority_queue<int, vector<int>, greater<int>> resultQ;
	queue<int> q;
	q.push(x);
	visited[x] = true;
	int dis = 0;
	while (!q.empty()) {
		int size = q.size();
		for (int i = 0; i < size; i++){
			int cur = q.front();
			q.pop();
			if (dis == k) {
				resultQ.push(cur);
				continue;
			}
			for (auto next : edge[cur]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.push(next);
			}
		}
		dis++;
	}
	if (resultQ.empty()) {
		cout << -1;
	}
	else {
		while (!resultQ.empty()) {
			cout << resultQ.top()<<'\n';
			resultQ.pop();
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n >> m >> k >> x;

	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;
		edge[from].push_back(to);
	}
	bfs();

	return 0;
}
