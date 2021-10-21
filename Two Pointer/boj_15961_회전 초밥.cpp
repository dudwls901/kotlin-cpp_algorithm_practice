//https://www.acmicpc.net/problem/15961
#include <iostream>
#include <algorithm>
//쿠폰 가지고 있으면 전체 초밥 종류에 +1
//투 포인터로 현재 범위의 초밥 종류 세기
//쿠폰 가지고 있는 초밥 들어오면 flag
//2<=n<=3000000
//2<=d<=3000
//2<=k<=3000
//k<=n
//1<=c<=d
//접시의 수 n 초밥의 가짓수 d 연속해서 먹는 접시의 수 k  쿠폰 번호 c

using namespace std;

int n, d, k, c;
int input[3000000];
int cnt[3001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n >> d >> k >> c;
	for (int i = 0; i < n; i++) {
		cin >> input[i];
	}
	int start = 0;
	int kind = 0;
	for (int i = 0; i < k; i++) {
		if (!cnt[input[i]]) {
			kind++;
		}
		cnt[input[i]]++;
	}

	int answer = kind;
	
	while (start <= n) {
		
		if (cnt[c]==0) {
			answer = max(answer, kind + 1);
		}
		else{
			answer = max(answer, kind);
		}
		if (!cnt[input[(start + k) % n]]++) {
			kind++;
		}
		if (--cnt[input[start]]==0) {
			kind--;
		}
		start++;
	}
	cout << answer;
	return 0;
}
