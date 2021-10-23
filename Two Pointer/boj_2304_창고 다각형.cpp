//https://www.acmicpc.net/problem/2304
#include <iostream>

using namespace std;

//1<=n<=1000
int n;
int answer = 0;
int input[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	int cnt = 0;
	int leftIdx = 0;
	int rightIdx = 0;
	for (int i = 0; i < n; i++) {
		int idx;
		cin >> idx;
		cin >> input[idx];
	}
	int sum = 0;
	int right = 1;
	for (; right <= 1000; right++) {
		if (input[leftIdx] <= input[right]) {
			answer += input[leftIdx] * (right - leftIdx);
			leftIdx = right;
		}
		if (input[right]) cnt++;
		if (n == cnt) break;
	}
	answer += input[right];
	while (right > leftIdx) {
		for (int i = right - 1; i >= leftIdx; i--) {		
			//우측 기둥보다 낮다면
			if (input[i] < input[right]) {
				answer += input[right];
			}
			//우측 기둥보다 높거나 같다면
			else {
				answer += input[i];
				right = i;
				break;
			}
		}
	}
	cout << answer;

	return 0;
}
