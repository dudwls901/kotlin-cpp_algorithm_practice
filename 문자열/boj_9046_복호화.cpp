//https://www.acmicpc.net/problem/9046
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

bool cmp(pair<int,char> a, pair<int,char> b) {
	return a.first > b.first;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;
	cin.ignore();
	while (t--) {
		string sen;
		getline(cin, sen);
		pair<int, char> chList[26] = { {0,' '} };
		for (int i = 0; i < sen.length(); i++) {
			if (isspace(sen[i])) continue;
			chList[sen[i] - 'a'] = { chList[sen[i] - 'a'].first+1,sen[i] };
		}
		sort(chList, chList + 26, cmp);

		if (chList[0].first != chList[1].first) {
			cout << chList[0].second<<'\n';
		}
		else {
			cout << '?' << '\n';
		}
		
	}



	return 0;
}
