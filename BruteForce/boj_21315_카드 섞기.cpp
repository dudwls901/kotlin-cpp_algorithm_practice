//https://www.acmicpc.net/problem/21315
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

//1<=n<=1000
//1<=k
//2^k<=n
int n;
int result[1000];
int card[1000];
void mix(int range, int cnt) {
	//range = 이전에 위로 올린 카드들
	//cnt = 현재 위로 올릴 카드 개수
	int newCard[1000];
	int idx = 0;
	for (int i = range-cnt; i < range; i++) {
		newCard[idx++] = card[i];
		card[i] = 0;
	}
	for (int i = 0; i < n; i++) {
		if (card[i] != 0) {
			newCard[idx++] = card[i];
		}
		card[i] = newCard[i];
	}
}

void solve(int k) {
	int range = n;
	for (int i = 1; i <= k + 1; i++) {
		int cnt = pow(2,k - i + 1);
		int a = 2;
		mix(range, cnt);
		range = cnt;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> result[i];
	}
	for (int k1 = 1; pow(2, k1) <= n; k1++) {
		for (int k2 = 1; pow(2, k2) <= n; k2++) {
			for (int i = 0; i < n; i++) {
				card[i] = i + 1;;
			}
			//2,k섞기 2번씩 완탐
			solve(k1);
			solve(k2);
			bool isFinish = true;
			for (int i = 0; i < n; i++) {
				if (result[i] != card[i]) {
					isFinish = false;
					break;
				}
			}
			if (isFinish) {
				cout << k1<<' '<<k2;
				return 0;
			}
		}
	}
	
	return 0;
}
