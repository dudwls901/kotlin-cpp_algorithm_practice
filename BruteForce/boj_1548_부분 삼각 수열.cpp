//https://www.acmicpc.net/problem/1548
#include <iostream>
#include <algorithm>
using namespace std;
int n;
//1<=n<=50
long long arr[50];
bool deleted[50];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int result = 1;
	sort(arr, arr+n);

	for (int first = 0; first < n - 1; first++) {
		for (int third = n - 1; third >= 0; third--) {
			if (first + 1 == third) break;
			if (arr[first] + arr[first + 1] > arr[third]) {
				result = max(result, third - first + 1);
				break;
			}
		}
	}
	if (result == 1 && n >= 2) {
		result = 2;
	}
	cout << result;
}
