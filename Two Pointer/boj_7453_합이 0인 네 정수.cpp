//https://www.acmicpc.net/problem/7453
#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 4000

using namespace std;
long long arr1[MAX*MAX], arr2[MAX*MAX];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int arr[4][MAX];
	long long answer = 0;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[0][i] >> arr[1][i] >> arr[2][i] >> arr[3][i];
	}
	long long idx = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			arr1[idx] = arr[0][i] + arr[1][j];
			arr2[idx] = arr[2][i] + arr[3][j];
			idx++;
		}
	}
	sort(arr1, arr1 + idx);
	sort(arr2, arr2 + idx);

	int p1 = 0, p2 = idx- 1;

	while (p1 < idx && p2 >= 0) {
		if (arr1[p1] + arr2[p2] == 0) {
			long long cnt1 = 0;
			int i = p1;
			while (i < idx && arr1[i] == arr1[p1]) {
				cnt1++;
				i++;
			}
			p1 = i;

			long long cnt2 = 0;
			i = p2;
			while (i >= 0 && arr2[i] == arr2[p2]) {
				cnt2++;
				i--;
			}
			p2 = i;
			answer += cnt1 * cnt2;
		}
		else if (arr1[p1] + arr2[p2] < 0) {
			p1++;
		}
		else {
			p2--;
		}
	}
	cout << answer;


	return 0;
}
