//https://www.acmicpc.net/problem/20438
#include <iostream>
using namespace std;
int N, K, Q, M;
//1<=KQ<=N<=5000
//1<=M<=50000
//N 학생의 수 K 졸고 있는 학생의 수, 출석 코드 보낼 학생의 수 Q, 주어질 구간의 수 M
bool sleep[5003];
int pSum[5003];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> N >> K >> Q >> M;
	
	//자는 사람
	for (int i = 0; i < K; i++) {
		int num;
		cin >> num;
		sleep[num] = true;
	}
	//출석이 되지 않은 학생은 1로 초기화
	for (int i = 3; i <= N+2; i++) {
		pSum[i] = 1;
	}
	//출석처리(0)
	//자는 사람은 다음 사람에게 전달하지 않는다.X
	//num은 본인의 배수인 사람들에게 전달하며, 본인이 직접 전달한다. 즉, next가 자고 있으면 그 사람만 건너뛰고 뒤에 사람들 계속 전달.
	for (int i = 0; i < Q; i++) {
		int num;
		cin >> num;
		if (sleep[num])continue;
		int next = num;
		while (next <= N+2) {
			if (sleep[next]) {
				next += num;
				continue;
			}
			pSum[next] = 0;
			next += num;
		}
	}
	for (int i = 4; i <= N+2; i++) {
		pSum[i] += pSum[i - 1];
	}
	for (int i = 0; i < M; i++) {
		int start, end;
		cin >> start >> end;
		cout << pSum[end] - pSum[start - 1]<<'\n';
	}

	return 0;
}
