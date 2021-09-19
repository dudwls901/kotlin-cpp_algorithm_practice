//https://www.acmicpc.net/problem/2503
#include <iostream>
#include <string>
#include <cstring>
#include <unordered_set>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n;
	bool arr[1000];
	memset(arr, true, 1000);
	cin >> n;
	for (int i = 0; i < n; i++) {
		int s,b;
		string num;
		cin >> num >> s >> b;
		for (int j = 123; j < 1000; j++) {
			int ss = 0, bb = 0;
			string num2 = to_string(j);
			unordered_set<char> se;
			//중복수 체크
			for (int k = 0; k < num2.length(); k++) {
				se.insert(num2[k]);
			}
			if (se.size() != 3) {
				arr[j] = false;
				continue;
			}
			//0체크
			if (se.find('0') != se.end()) {
				arr[j] = false;
				continue;
			}

			//s,b개수 맞는지 확인
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					if (k == l && num[k] == num2[l]) {
						ss++;
						continue;
					}
					if (num[k] == num2[l]) {
						bb++;
					}
				}
			}
			if (ss != s || bb != b) {
				arr[j] = false;
			}
		}
	}
	int answer = 0;
	for (int i = 123; i < 1000; i++) {
		if (arr[i]) {
			answer++;
			//cout << i << '\n';
		}
	}
	cout << answer << '\n';

	return 0;
}
