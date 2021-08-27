//https://www.acmicpc.net/problem/2003
#include <iostream>

using namespace std;

int arr[10000];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n, m;
	int answer = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int p1 = 0, p2 = 0;
	int sum = 0;
	while (p1 < n) {
		if (sum == m) {
			answer++;
		}
		else if (sum > m) {
			sum-=arr[p1++];
			continue;
		}

		if (p2 < n) {
			sum += arr[p2++];
		}
		else {
			sum -= arr[p1++];
		}

	}
	cout << answer;
}
