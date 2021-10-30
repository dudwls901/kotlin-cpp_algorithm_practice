//https://www.acmicpc.net/problem/2512
#include <iostream>
#include <algorithm>
using namespace std;


// 3<= n<= 10000 지방의 수
//n<=m<=1000000000 총 예산
//1<=value<=100000
int input[10000];
int n;
int m;
int answer = 0;

long long cal(int mid) {
	long long sum = 0;
	for (int i = 0; i < n; i++) {
		if (input[i] > mid) {
			sum += mid;
		}
		else {
			sum += input[i];
		}
	}
	return sum;
}

void biSearch(int start,int end) {
	int mid = (start + end) / 2;
	long long result = cal(mid);
	if (start > end) {
		return;
	}
	if (result <= m) {
		answer = mid;
		biSearch(mid + 1, end);
	}
	else {
		biSearch(start, mid-1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	int end = 0;
	for (int i = 0; i < n; i++) {
		cin >> input[i];
		end = max(end, input[i]);
	}
	cin >> m;

	biSearch(1, end);
	cout << answer;
	return 0;
}
