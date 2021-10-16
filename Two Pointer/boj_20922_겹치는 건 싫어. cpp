//https://www.acmicpc.net/problem/20922
#include <iostream>
#include <algorithm>
using namespace std;


//1<=n<=200000
//1<=k<=100
//같은 원소가 k개 이하로 들어있는 최장 연속 부분 수열 길이
int arr[200000];
int cnt[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n, k;
	cin >> n >> k;

	int answer = 0;
	int start=0;
	for (int i = 0; i < n; i++) {
		cin >>arr[i];
		cnt[arr[i]]++;
        //arr[i]를 수열에 포함시켰는데 arr[i]의 빈도수가 k보다 큰 경우 start 증가
		while(cnt[arr[i]] > k) {
			cnt[arr[start++]]--;
		}
		answer = max(answer, i-start+1);
	}
	cout << answer;

	return 0;
}
