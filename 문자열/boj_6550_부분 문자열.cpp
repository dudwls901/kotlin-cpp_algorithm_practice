//https://www.acmicpc.net/problem/6550
#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string a, b;
	while (cin >> a >> b) {
		int aIdx = 0;
		bool isTrue = false;
		for (int i = 0; i < b.length(); i++) {
			if (a[aIdx] == b[i]) {
				aIdx++;
			}
			if (aIdx == a.length()) {
				isTrue = true;
				break;
			}
		}
		if (isTrue) {
			cout << "Yes\n";
		}
		else {
			cout << "No\n";
		}
	}


	return 0;
}
