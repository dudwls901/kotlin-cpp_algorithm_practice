//https://www.acmicpc.net/problem/12919
#include <iostream>
#include <string>
using namespace std;

bool result;

void solve(string s, string t, int sP, int eP,bool isReverse) {
	if (s.length() == eP-sP+1) {
		bool isFinish = true;
		
		
		for (int i = 0; i < s.length(); i++) {
			if (isReverse) {
				if (s[i] != t[eP--]) {
					isFinish = false;
					break;
				}
			}
			else {
				if (s[i] != t[sP++]) {
					isFinish = false;
					break;
				}
			}
		}
		if (isFinish) result = true;
		return;
	}
	if (isReverse) {
		//뒤집혀있으면 e가 처음
		if (t[eP] == 'B') {
			solve(s, t, sP, eP-1, !isReverse);
		}
		//뒤집혀있으면 s가 끝
		if (t[sP] == 'A') {
			solve(s, t, sP+1, eP, isReverse);
		}
	}
	else {
		if (t[sP] == 'B') {
			solve(s, t, sP+1, eP, !isReverse);
		}
		if (t[eP] == 'A') {
			solve(s, t, sP, eP-1, isReverse);
		}
	}

}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	string s, t;
	cin >> s >> t;


	int sP = 0;
	int eP = t.length() - 1;

	solve(s, t, sP, eP,false);
	cout << result;
	return 0;
}
