//https://www.acmicpc.net/problem/14719
#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int h, w;
	cin >> h >> w;
	int input[501];
	for (int i = 1; i <= w; i++) {
		cin >> input[i];
	}
	int left = 1;
	int answer = 0;
	int sum = 0;
	int right = 2;
	for (; right <= w; right++) {
		//크거나 같은 기둥 만났을 때
		if (input[left] <= input[right]) {
			answer += sum;
			left = right;
			sum = 0;
		}
		//작은 기둥 만났을 때
		else {
			sum += input[left] - input[right];
		}
	}
	
	right--;
	sum = 0;
	while (left < right) {
		for (int i = right - 1; i >= left; i--) {
			if (input[i] < input[right]) {
				sum += input[right] - input[i];
			}
			else {
				right = i;
				break;
			}
		}
	}
	answer += sum;
	cout << answer;

	return 0;
}
