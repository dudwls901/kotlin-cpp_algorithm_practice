//https://www.acmicpc.net/problem/16947
#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
#define MAX 3001
using namespace std;
//3<=n<=3000
//모든 정점의 순환선에 대한 거리를 출력
int n;
bool cycle[MAX];//사이클 노드 저장
vector<int> edge[MAX];//간선
bool visited[MAX];
int pre[MAX];//이전 방문했던 노드들(사이클 찾을 때 사용)
bool hasCycle;
int dist[MAX];
void bfs() {
	
	queue<pair<int, int>> q;
	for (int i = 1; i <= n; i++) {
		if (cycle[i]) {
			visited[i] = true;
			q.push({ i,0 });
		}
	}
	while (!q.empty()) {
		int cur = q.front().first;
		int dis = q.front().second;
		q.pop();
		visited[cur] = true;
		
		for (int i = 0; i < edge[cur].size(); i++) {
			int next = edge[cur][i];
			if (visited[next]) continue;
			dist[next] = dis + 1;
			q.push({ next,dis + 1 });
		}
	}
}

void findCycle(int cur) {
	visited[cur] = true;
	for (int i = 0; i < edge[cur].size(); i++) {
		//사이클을 찾았다면 다른 dfs 모두 종료
		if (hasCycle) return;
		int next = edge[cur][i];
		if (visited[next]) {
			//부모가 아닌 다른 방문했던 노드(역간선)이면 사이클임
			if (next != pre[cur]) {
				//사이클 완성, cycle에 사이클 노드 저장
				cycle[cur] = true;
				hasCycle = true;
				while (cur != next) {
					cycle[pre[cur]] = true;
					cur = pre[cur];
				}
				return;
			}
			
		}
		else {
			pre[next] = cur;
			findCycle(next);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		int from, to;
		cin >> from >> to;
		edge[from].push_back(to);
		edge[to].push_back(from);
	}
	findCycle(1);
	memset(visited, false, MAX);
	bfs();
	for (int i = 1; i <= n; i++) {
		cout << dist[i]<<' ';
	}
	return 0;
}
