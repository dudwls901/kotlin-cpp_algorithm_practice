//https://www.acmicpc.net/problem/2021
#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int a, b, c, d;
	cin >> a >> b >> c >> d;

	int time = 24;
	int answer = 0;
	int tired = 0;
	while (time--) {
		if (a + tired <= d) {
			answer += b;
			tired += a;
		}
		else {
			tired -= c;
			if (tired < 0)tired = 0;
		}
	}
	cout << answer;


	return 0;
}
