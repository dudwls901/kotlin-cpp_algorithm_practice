//https://www.acmicpc.net/problem/1647
//프림
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

//2<=n<=100000
//1<=m<=1000000
//<=가중치 <=1000
int n, m;
vector<pair<int,int>> edge[100001];
bool visited[100001];

int prim() {
	priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int >>> pq;
	int result=0;
	int maxCost = 0;
	pq.push( { 0,1 });

	for (int i = 1; i <= n; i++) {
		while (!pq.empty() &&visited[pq.top().second]) {
			pq.pop();
		}
		int next = pq.top().second;
		int minCost = pq.top().first;
		maxCost = max(maxCost, minCost);
		visited[next] = true;
		result += minCost;
		for (auto o : edge[next]) {
			pq.push({ o.second,o.first });
		}
	}
	return result-maxCost;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	
	for (int i = 0; i < m; i++) {
		int from, to, cost;
		cin >> from >> to >> cost;
		edge[from].push_back({ to ,cost });
		edge[to].push_back({ from,cost });
	}	

	cout << prim();
	


	return 0;
}
//크루스칼
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int n, m;
int parent[100001];
int result;
int getParent(int num) {
	if (num == parent[num]) return num;
	return parent[num] = getParent(parent[num]);

}
void unionParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);

	if (a != b) {
		parent[a]= b;
	}
}
bool findParent(int a, int b) {
	a = getParent(a);
	b = getParent(b);
	if (a == b) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	vector<pair<int, pair<int, int>>> edge(m);
	for (int i = 0; i < m; i++) {
		int cost, a, b;
		cin >> a >> b >> cost;
		edge[i] = { cost,{a,b} };
	}
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}
	sort(edge.begin(), edge.end());

	int maxCost = 0;
	for (int i = 0; i < m; i++) {
		int cost = edge[i].first;
		int a = edge[i].second.first;
		int b = edge[i].second.second;
		if (!findParent(a, b)) {
			maxCost = max(maxCost, cost);
			result += cost;
			unionParent(a, b);
		}
	}
	cout << result-maxCost;

	return 0;
}
