//https://www.acmicpc.net/problem/9177
#include <iostream>
#include <string>
#include <queue>
#include <cstring>
using namespace std;

string dataSet[3];
bool visited[201][201];
struct info {
	int left, right, findIdx;
};

bool bfs() {
	queue<info> q;
	q.push({ 0,0,0 });
	visited[0][0] = true;
	while (!q.empty()) {
		int left = q.front().left;
		int right = q.front().right;
		int findIdx = q.front().findIdx;
		q.pop();
		if (findIdx == dataSet[2].length()) {
			return true;
		}
		if (left<dataSet[0].length() && dataSet[0][left] == dataSet[2][findIdx] && visited[left+1][right]==false) {
			q.push({ left + 1,right, findIdx + 1 });
			visited[left+1][right] = true;
		}
		if (right<dataSet[1].length() && dataSet[1][right] == dataSet[2][findIdx] && visited[left][right+1] == false) {
			q.push({ left, right + 1, findIdx + 1 });
			visited[left][right+1] = true;
		}
	}
	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;
	for (int i = 1; i <= t; i++) {
		cin >> dataSet[0] >> dataSet[1] >> dataSet[2];
		bool answer =bfs();
		cout << "Data set " << i << ": ";
		if (answer) {
			cout << "yes\n";
		}
		else {
			cout << "no\n";
		}
		memset(visited, false, 201 * 201);
	}
	

	return 0;
}
