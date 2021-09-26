//https://www.acmicpc.net/problem/2493
#include <iostream>
#include <vector>
#include <stack>

using namespace std;
//1<=N<=500000
//1<=high<=100000000
int high[500000];
int answer[500000];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> high[i];
	}
	stack<pair<int, int>> stk;
	stk.push({ high[n - 1],n - 1 });
	for (int i = n - 2; i >= 0; i--) {
		while (!stk.empty() && stk.top().first < high[i]) {
			answer[stk.top().second] = i + 1;
			stk.pop();
		}
		
		stk.push({ high[i],i });
	}
	for (int i = 0; i < n; i++) {
		cout << answer[i] << ' ';
	}
	return 0;
}
