//https://www.acmicpc.net/problem/2224
#include <iostream>
#include <string>

using namespace std;

int n;
//1<=n<=10000
bool dp[58][58];
int cnt = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		string input;
		getline(cin, input);
		//a=>a인 경우 skip
		if (input[0] == input[input.length() - 1]) continue;
		//중복입력인 경우 skip
		if (dp[input[0] - 'A'][input[input.length() - 1] - 'A']) continue;
		cnt++;
		dp[input[0] - 'A'][input[input.length() - 1] - 'A'] = true;
	}

	//
	for (int k = 0; k < 58; k++) {
		for (int i = 0; i < 58; i++) {
			for (int j = 0; j < 58; j++) {
				//이미 참이라고 밝혀진 경우 스킵
				if (dp[i][j] || i==j)continue;
				//i=>k 이고, k=>j 이면 i=>j
				dp[i][j] = dp[i][k] && dp[k][j];
				if (dp[i][j])
					cnt++;
			}
		}
	}

	cout << cnt << '\n';
	for (int i = 0; i < 58; i++) {
		for (int j = 0; j < 58; j++) {
			if (dp[i][j]) {
				cout << (char)(i + 'A') << " => " << (char)(j + 'A')<<'\n';
			}
		}
	}
	return 0;
}
