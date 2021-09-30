//https://www.acmicpc.net/problem/2352
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int dp[40000];
int arr[40000];
int biSearch( int start, int end, int val) {
	if (start == end) {
		return start;
	}
	int mid = (start + end) / 2;
	if (dp[mid] < val) {
		return biSearch(mid+1, end, val);
	}
	else if (dp[mid] == val) {
		return mid;
	}
	else {
		return biSearch(start, mid, val);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;
	cin >> arr[0];
	dp[0] = arr[0];
	int idx = 0;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		if (dp[idx] < arr[i]) {
			dp[++idx]=arr[i];
		}
		else {
			dp[biSearch(0,idx, arr[i])] = arr[i];
		}
	}
	cout << idx+1;
	

	return 0;
}
