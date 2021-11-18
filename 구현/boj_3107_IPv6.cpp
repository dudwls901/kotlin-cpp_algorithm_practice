//https://www.acmicpc.net/problem/3107
#include <iostream>
#include <string>
using namespace std;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string input;
	cin >> input;
	string answer = "";
	//int idx=
	int partCnt = 0;
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == ':') {
			partCnt++;
		}
	}
	int len = 0;
	for (int i = input.length() - 1; i >= 0; i--) {
		if (input[i] == ':') {
			while (len < 4) {
				answer = '0' + answer;
				len++;
			}
			if (i - 1 >= 0 && input[i - 1] == ':') {
				len = 0;
				int cnt = 8 - partCnt;
				if (i - 1 == 0) {
					cnt++;
				}
				while (cnt--) {
					answer = "0000" + answer;
				}
				i--;
				continue;
			}
			len = 0;
		}
		else {
			len++;
			answer = input[i] + answer;
		}
	}
	if (len > 0) {
		while (len < 4) {
			answer = '0' + answer;
			len++;
		}
	}
	int idx = 3;
	for (int i = 0; i < answer.length(); i++) {
		cout << answer[i];
		if (i == idx && idx!=answer.length()-1) {
			cout << ':';
			idx += 4;
		}
	}

	return 0;
}
