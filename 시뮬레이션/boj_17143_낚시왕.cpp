//https://www.acmicpc.net/problem/17143
#include <iostream>
#include <algorithm>
#include <queue>
#include <unordered_map>
#include <string>
using namespace std;


//2<=r<=c<=100
//0<=m<=r*c
//0<=s<=1000
//1<=d<=4 상하우좌 ^1로방향역전
//1<=z<=10000

struct Shark {
	int r;
	int c;
	int s;
	int d;
	int z;
};

struct cmp {
	bool operator()(const Shark &a, const Shark &b) {
		return a.r > b.r;
	}
};

int R, C, M;
//열별로 저장된 상어의 행 오름차순
priority_queue<Shark, vector<Shark>, cmp> sharks[101];
int dir[4][2] = { {-1,0},{1,0},{0,1},{0,-1} };

bool isInside(int curR,int curC){
	if (curR < 0 || curR >= R || curC < 0 || curC >= C) return false;
	return true;
}

void moveShark() {
	
	unordered_map<string,Shark> ma;
	for (int i = 0; i < C; i++) {
		while (!sharks[i].empty()) {
			//한 마리씩 이동
			Shark shark = sharks[i].top();
			for (int j = 0; j < shark.s; j++) {
				if (!isInside(shark.r+dir[shark.d][0], shark.c+dir[shark.d][1])) {
					shark.d = shark.d ^ 1;
				}
				shark.r += dir[shark.d][0];
				shark.c += dir[shark.d][1];
			}

			string key = to_string(shark.r)+" "+to_string(shark.c);
			//상어 좌표가 겹치면 사이즈 큰 상어로 갱신(잡아먹기)
			if (ma[key].z!=0){
				if (shark.z > ma[key].z) {
					ma[key] = shark;
				}
			}
			else {
				ma[key] = shark;
			}
			sharks[i].pop();
		}
	}
	
	//map에 저장된 이동된 상어들을 sharks에 옮기기
	for (auto o : ma) {
		sharks[o.second.c].push(o.second);
	}
}

int solve(){
	int result = 0;
	//낚시왕의 이동
	for (int i = 0; i < C; i++) {
		//해당 열에 상어가 있으면 점수 +
		if (sharks[i].empty()) {
			moveShark();
			continue;
		}
		int topR = sharks[i].top().r;
		result += sharks[i].top().z;
		sharks[i].pop();
        
		//살아남은 상어 이동
		moveShark();
	}

	return result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> R >> C >> M;
	
	for (int i = 0; i < M; i++) {
	//s속력 d방향 z크기 
		int r, c, s, d, z;
		cin >> r >> c >> s >> d >> z;
		//열 별로 상어를 저장
        if (d >= 3) {
			s %= (C - 1) * 2;
		}
		//상하
		else {
			s %= (R - 1) * 2;
		}
		sharks[c-1].push({ r-1,c-1,s,d-1,z });
	}
	cout <<solve();
	return 0;
}
