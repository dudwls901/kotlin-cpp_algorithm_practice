//https://www.acmicpc.net/problem/11047
#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, k,answer=0;
	cin >> n >> k;
	int arr[10];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = n - 1; i >= 0; i--) {
		if (k / arr[i] != 0) {
			answer += k / arr[i];
			k %= arr[i];
		}
		if (k == 0)break;
	}
	cout << answer;

	return 0;
}
