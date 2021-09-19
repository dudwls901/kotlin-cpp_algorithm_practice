//https://www.acmicpc.net/problem/1969
#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n, m;
	cin >> n >> m;
	//n<1000
	//m<=50
	

	string input[1000];
	int sum = 0;
	string ans = "";
	for (int i = 0; i < n; i++) {
		cin >> input[i];
	}
	for (int i = 0; i < m; i++) {
		map<char, int> ma;
		for (int j = 0; j < n; j++) {
			ma[input[j][i]]++;
		}
		char ch;
		int max=0;
		for (auto o : ma) {
			if (max < o.second) {
				max = o.second;
				ch = o.first;
			}
		}
		ans += ch;
		sum += n-max;
	}
	cout << ans << '\n' << sum;
	return 0;
}
