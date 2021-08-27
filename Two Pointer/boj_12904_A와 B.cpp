//https://www.acmicpc.net/problem/12904
#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	string s, t;
	cin >> s >> t;

	int answer = 1;
	bool isReverse = false;

	while (s.length() != t.length()) {
		int sP = 0;
		int eP = t.length() - 1;
		if (isReverse) {
			if (t[sP] == 'B') 
				isReverse = false;
			t.erase(t.begin());
		}
		else {
			if (t[eP] == 'B')
				isReverse = true;
			t.pop_back();
			
		}
	}
	if (isReverse) {
		for (int i = s.length()-1; i >= 0; i--) {
			if (t[i] != s[s.length() - i - 1]) {
				answer = 0;
				break;
			}
		}
	}
	else {
		for (int i = 0; i < t.length(); i++) {
			if (t[i] != s[i]) {
				answer = 0;
				break;
			}
		}
	}
	cout << answer;
}
