//https://www.acmicpc.net/problem/21608
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//1. 인접한 칸에 좋아하는 학생이 많은 순
//2. 인접한 칸에 빈자리가 많은 순
//3. 행의 번호가 가장 작은 순
//4. 열의 번호가 가장 작은 순

//3<=n<=20

int n;
int stuSeq[400];
bool love[400][400];
int visited[20][20];
int dir[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };

bool cmp(pair<pair<int,int>,pair<int,int>> &a, pair<pair<int, int>, pair<int, int>> &b) {
	if (a.first.first == b.first.first) {
		if (a.first.second == b.first.second) {
			if (a.second.first == b.second.first) {
				return a.second.second < b.second.second;
			}
			return a.second.first < b.second.first;
		}
		return a.first.second > b.first.second;
	}
	return a.first.first > b.first.first;
}

int stfCnt() {
	int result = 0;
	int satisfication[5] = { 0,1,10,100,1000 };
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int loveCnt = 0;
			int stuNum = visited[i][j];
			for (int k = 0; k < 4; k++) {
				int nR = i + dir[k][0];
				int nC = j + dir[k][1];
				if (nR < 0 || nR >= n || nC < 0 || nC >= n) continue;
				if (love[stuNum][visited[nR][nC]] != 0) loveCnt++;
			}
			result += satisfication[loveCnt];
		}
	}
	return result;
}

void sit(int idx) {
	int stuNum = stuSeq[idx];
	vector<pair<pair<int, int>, pair<int, int>>> canSit;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j]) continue;
			int loveStu = 0;
			int empty = 0;
			for (int k = 0; k < 4; k++) {
				
				int nR = i+dir[k][0];
				int nC = j + dir[k][1];
				if (nR < 0 || nR >= n || nC < 0 || nC >= n) {
				
					continue;
				}
				if (love[stuNum][visited[nR][nC]] != 0) loveStu++;
				else if(!visited[nR][nC]) empty++;
			}
			canSit.push_back({ {loveStu,empty} ,{i,j} });
		}
	}
	//모든 자리 검사 끝
	
	//조건에 맞게 정렬해서 맨 앞에 있는 자리 선택
	sort(canSit.begin(), canSit.end(), cmp);

	int seatR = canSit[0].second.first;
	int seatC = canSit[0].second.second;
	visited[seatR][seatC] = stuNum;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n*n; i++) {
		cin >> stuSeq[i];
		for (int j = 1; j < 5; j++) {
			int loveStu;
			cin >> loveStu;
			love[stuSeq[i]][loveStu] = true;
		}
	}
	for (int i = 0; i < n*n; i++) {
		sit(i);
	}
	cout <<stfCnt();
	
	return 0;
}
