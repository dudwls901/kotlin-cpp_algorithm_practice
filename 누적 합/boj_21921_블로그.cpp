//https://www.acmicpc.net/problem/21921
#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, x;
	cin >> n >> x;
	int sum = 0;
	int arr[250000];
	for (int i = 0; i < x; i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	int answer = sum;
	int cnt = 1;
	for (int i = x; i < n; i++) {
		cin >> arr[i];
		sum += arr[i] - arr[i - x];
		if (sum >= answer) {
			if (sum == answer) {
				cnt++;
			}
			else {
				answer = sum;
				cnt = 1;
			}
		}
	}
	if (answer == 0) {
		cout << "SAD";
	}
	else
		cout << answer << '\n' << cnt;
	return 0;
}
