//https://www.acmicpc.net/problem/20291
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n;
	cin >> n;
	map<string, int> file;
	for (int i = 0; i < n; i++) {
		string input;
		cin >> input;
		istringstream ss(input);
		string strBuffer;
		vector<string> str;
		while (getline(ss, strBuffer, '.')) {
			str.push_back(strBuffer);
		}
		file[str[1]]++;
	}
	for (auto o : file) {
		cout << o.first << ' ' << o.second << '\n';
	}

	return 0;
}


//1 <= n <=50000
