//https://www.acmicpc.net/problem/10974
#include <iostream>
#include <vector>

using namespace std;

int n;
bool visited[9];

void permutation(int cnt,vector<int> result) {
	if (cnt == n) {
		for (int i = 0; i < cnt; i++) {
			cout << result[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = 1; i <= n; i++) {
		if (visited[i]) continue;
		visited[i] = true;
		result[cnt] = i;
		permutation(cnt + 1,result);
		visited[i] = false;

	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;

	vector<int> result(n);
	permutation(0,result);


	return 0;
}
