//https://www.acmicpc.net/problem/2021
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define MAX 200001
using namespace std;

int n, m, start, e;
int visited[MAX];
vector<int> graph[MAX];

int bfs() {
	queue<pair<int, int>> q;
	q.push({ -1, start });

	while (!q.empty()) {
		int cur = q.front().second;
		int dis = q.front().first;
		q.pop();
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur][i];
			if (visited[next] > -1)
				continue;
			//호선
			if (next > 100000) {
				q.push({ dis + 1,next });
				visited[next] = dis + 1;
			}
			//도착
			else if (next == e) {
				return dis;
			}
			//역
			else {
				q.push({ dis,next });
				visited[next] = dis;
			}

		}
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 1; i <= m; i++) {
		int num;
		cin >> num;
		while (num != -1) {
			graph[num].push_back(i + 100000);
			graph[i + 100000].push_back(num);
			cin >> num;
		}
	}
	cin >> start >> e;
	fill_n(visited, MAX, -1);

	cout << bfs();

	return 0;
}
