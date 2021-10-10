//https://www.acmicpc.net/problem/1789
#include <iostream>

using namespace std;

long long n;
long long answer;
void biSearch(long long start, long long end) {
	
	if (start >= end) {
		return;
	}
	long long mid = (start + end) / 2;
	long long result = mid * (mid + 1) / 2;
	
	if (result <= n) {
		answer= mid;
		biSearch(mid + 1, end);
	}
	else {
		biSearch(start, mid);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n;
	 biSearch(1, n);
	 cout << answer;
	 return 0;
}
