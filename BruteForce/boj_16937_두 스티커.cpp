//https://www.acmicpc.net/problem/16937
#include <iostream>
#include <algorithm>
using namespace std;
//1<= h,w,n<=100
//1<=r,c<=100
int h, w, n;
pair<pair<int,int>,int> sticker[200];
bool visited[100];
pair<int,int> stk[2];
int answer;
//스티커는 두 개만 붙인다.
//n이 1인 경우 스티커가 한 개이니 0 출력
//스티커 두 개 붙일 수 없는 경우 0 출력
//가로로 붙이는 경우 두 스티커의 가로 합이 w보다 작, 두 스티커 중 세로가 큰 게 h보다 작
//세로로 붙이는 경우 두 스티커의 세로 합이 h보다 작, 두 스티커 중 가로가 큰 게 w보다 작

void check() {
	//가로로 붙이기
	if(stk[0].second+stk[1].second<=w && max(stk[0].first,stk[1].first)<=h){
		answer = max(answer, stk[0].first*stk[0].second + stk[1].first*stk[1].second);
	}
	//세로로 붙이기
	if (stk[0].second+stk[1].second<=h && max(stk[0].first,stk[1].first)<=w) {
		answer = max(answer, stk[0].first*stk[0].second + stk[1].first*stk[1].second);
	}
}
void combination(int idx, int size, int cnt) {
	if (cnt == 2) {
		check();
		return;
	}
	for (int i = idx; i < size; i++) {
		int nextR = sticker[i].first.first;
		int nextC = sticker[i].first.second;
		int stkNum = sticker[i].second;
		if (visited[stkNum]) continue;
		visited[stkNum] = true;
		stk[cnt] = { nextR,nextC };
		combination(idx + 1, size, cnt + 1);
		stk[cnt] = { 0,0 };
		visited[stkNum] = false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	//input
	cin >> h >> w >> n;
	int idx = 0;
	for (int i = 0; i < n; i++) {
		int r, c;
		cin >> r >> c;
		sticker[idx++] = { {r,c},i };
		if (r != c) {
			sticker[idx++] = { {c,r},i };
		}
	}

	combination(0, idx, 0);
	cout << answer;
	return 0;
}
