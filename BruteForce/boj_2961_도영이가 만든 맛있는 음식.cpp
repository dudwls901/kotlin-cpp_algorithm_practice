//https://www.acmicpc.net/problem/2961
#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
pair<int, int> input[10];
//1<=n<=10
pair<int, int> result[10];
int answer = 987654321;
void combination(int idx, int cnt) {
	if (cnt > 0) {
		int s = result[0].first;
		int b = result[0].second;
		for (int i = 1; i < cnt; i++) {
			s *= result[i].first;
			b += result[i].second;
		}
		answer = min(answer, abs(s - b));
	}
	if (cnt == n) {
		return;
	}
	for (int i = idx; i < n; i++) {
		result[cnt] = { input[i].first,input[i].second};
		combination(i + 1, cnt + 1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> input[i].first;
		cin >> input[i].second;
	}
	combination(0,0);
	cout << answer;
	return 0;
}
