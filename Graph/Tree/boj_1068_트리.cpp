//https://www.acmicpc.net/problem/1068
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool deleted[50];
vector<int> graph[50];
int answer = 0;
int n;
//n>0 n<=50

//노드 삭제
void bfs(int start) {
	queue<int> q;
	q.push(start);
		while (!q.empty()) {
			int cur = q.front();
			q.pop();
			deleted[cur] = true;
			for (int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur][i];
				if (deleted[next])
					continue;
				q.push(next);
			
			}
		}


}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	
	cin >> n;
	int start = 0;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		if (num == -1) {
			start = i;
			continue;
		}
		graph[num].push_back(i);
	}
	int delete_num;
	cin >> delete_num;
	bfs(delete_num);

	//리프노드 탐색
	for (int i = 0; i < n; i++) {
		//
		if(!deleted[i]){
			int j=-1;
			for (j = 0; j < graph[i].size(); j++) {
				if (!deleted[graph[i][j]])
					break;
			}
			if (j == graph[i].size())
				answer++;
		}
	}
	cout << answer;
	return 0;
}
