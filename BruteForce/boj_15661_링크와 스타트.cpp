//https://www.acmicpc.net/problem/15661
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;


int n;
int graph[20][20];
bool visited[20];
int pairs[2];
int answer = 987654321;

int cal() {
	int cnt1 = 0;
	int cnt2 = 0;
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (visited[i] && visited[j]) {
				cnt1 += graph[i][j] + graph[j][i];
			}
			else if (!visited[i] && !visited[j]) {
				cnt2 += graph[i][j] + graph[j][i];
			}
		}
	}
	return abs(cnt1 - cnt2);
}

void combination(int cnt) {
	if (cnt == n) {
		//팀 비교
		answer =min(answer,cal());
		return;
	}
		visited[cnt] = true;
		combination(cnt + 1);
		visited[cnt] = false;
		combination(cnt + 1);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> graph[i][j];
		}
	}

	combination(0);
	cout << answer;
	return 0;
}
