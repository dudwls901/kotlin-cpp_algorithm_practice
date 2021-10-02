//https://www.acmicpc.net/problem/2407
#include <iostream>
#include <string>
using namespace std;

int n, m;

string combi[101][101];

string addNum(string a, string b) {
	string result="";
	if (a.length() > b.length()) {
		while (a.length() != b.length()) {
			b = '0' + b;
		}
	}
	else {
		while (a.length() != b.length()) {
			a = '0' + a;
		}
	}
	int sum = 0;
	for (int i = a.length()-1; i >=0; i--) {
	
		sum += a[i] - '0';
		sum += b[i] - '0';
		
		result = to_string(sum % 10) + result;
		if (sum >= 10) {
			
			sum = 1;
		}
		else {
			sum = 0;
		}
	}
	if (sum == 1) {
		return '1' + result;
	}

	return result;
}

void makeCombi() {
	combi[0][0] = "1";
	combi[1][0] = combi[1][1] = "1";
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= m; j++) {
			if (i == j || j==0) {
				combi[i][j] = "1";
			}
			else {
				combi[i][j] = addNum(combi[i - 1][j - 1], combi[i - 1][j]);
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	makeCombi();
	cout << combi[n][m];

	return 0;
}
