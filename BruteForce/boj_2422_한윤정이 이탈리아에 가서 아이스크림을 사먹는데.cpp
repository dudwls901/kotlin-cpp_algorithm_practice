//https://www.acmicpc.net/problem/2422
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m;
bool nope[201][201];
int ans;
vector<int> result;
void combination(int size,int idx) {
	if (size == 3) {
		if (nope[result[0]][result[1]]) {
			return;
		}
		else if (nope[result[0]][result[2]]) {
			return;
		}
		ans++;
		return;
	}
	for (int i = idx; i <= n; i++) {
		if (nope[idx][i]) continue;
		if (idx == i) continue;
		result.push_back(i);
		combination(size + 1, i);
		result.pop_back();
	}
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	// (1 ≤ N ≤ 200, 0 ≤ M ≤ 10,000)
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int from, to;
		cin >> from >> to;
		nope[from][to] = true;
		nope[to][from] = true;
	}
	combination(0,0);
	cout << ans;
	return 0;
}
