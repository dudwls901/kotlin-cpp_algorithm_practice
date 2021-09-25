//https://www.acmicpc.net/problem/16570
#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> makeTable(vector<int> &pattern) {
	vector<int> table(n, 0);
	int j = 0;
	for (int i = 1; i < n; i++) {
		while (j > 0 && pattern[i] != pattern[j]) {
			j = table[j - 1];
		}
		if (pattern[j] == pattern[i]) {
			table[i] = ++j;
		}
	}
	return table;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	//2<=n<=1000000
	cin >> n;
	vector<int> pattern(n);
	for (int i = 0; i < n; i++) {
		cin >>pattern[n-1-i];
	}
	vector<int> table = makeTable(pattern);
	int maxK = 0;
	int cnt = 0;
	for (int i = 1; i < table.size(); i++) {
		if (maxK < table[i]) {
			maxK = table[i];
			cnt = 1;
		}
		else if (maxK == table[i]) {
			cnt++;
		}
	}
	if (maxK == 0) {
		cout << -1;
	}
	else {
		cout << maxK << ' ' << cnt;
	}


	return 0;
}
