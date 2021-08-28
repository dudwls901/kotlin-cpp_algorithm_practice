//https://www.acmicpc.net/problem/1931
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<int,int>a, const pair<int,int> b) {
	if (a.second == b.second)return a.first < b.first;
	else return a.second < b.second;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	int answer = 0;
	cin >> n;
	vector<pair<int, int>> vt(n);
	int end = 0;
	for (int i = 0; i < n; i++) {
		int a, b;
		cin >> a >> b;
		vt[i] = { a, b };
	}
	sort(vt.begin(), vt.end(), cmp);
	
	for (int i = 0; i < n; i++) {
		if (vt[i].first >= end) {
			answer++;
			end = vt[i].second;
		}
	}
	cout << answer;
	return 0;
}
