//https://www.acmicpc.net/problem/14938
#include <iostream>
#include <vector>
#include <algorithm>

#define INF 987654321

using namespace std;


//간선 개수 1<= r <=1000
//노드 개수 1<= n <=100
//수색 범위 1<= m <=15
//각 노드의 아이템 수 1<= ㅣ <= 15
//양방향 그래프
//플로이드 와샬로 모든 정점에서 모든 정점에 대한 거리 구하기
//모든 정점을 시작점으로 하여 수색 범위 내의 아이템들을 모으고 최댓값 찾기
int answer;
int n, m, r;
int item[101];
int graph[101][101];
vector<pair<int, int>> edge[100];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> r;
	for (int i = 1; i <= n; i++) {
		cin >> item[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j) {
				graph[i][j] = 0;
			}
			else {
				graph[i][j] = INF;
			}
		}
	}
	//간선 입력
	for (int i = 0; i < r; i++) {
		int from, to, dis;
		cin >> from >> to >> dis;
		edge[from].push_back({ to,dis });
		edge[to].push_back({ from,dis });
		graph[from][to] = dis;
		graph[to][from] = dis;
	}
	
	//플로이드 와샬
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = min(graph[i][k] + graph[k][j], graph[i][j]);
			}
		}
	}

	//정점 별로 아이템 수색
	for (int i = 1; i <= n; i++) {
		int cnt = 0;
		for (int j = 1; j <= n; j++) {
			if (graph[i][j] <= m) {
				cnt += item[j];
			}
		}
		answer = max(answer, cnt);
	}
	cout << answer;
	return 0;
}
