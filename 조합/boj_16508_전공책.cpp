//https://www.acmicpc.net/problem/16508
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
string t;
int n;
int tChar[26];
int selectedChar[26];
pair<int,string> book[16];
int result =987654321;
//1<=tLen<=10
//1<=n<=16
//조합인데 16이고 중복 가능한 조합이라 그냥은 시간 초과??

bool check() {
	for (int i = 0; i < 26; i++) {
		if (tChar[i] > selectedChar[i]) {
			return false;
		}
	}
	return true;
}

void combination(int cnt,int priceSum) {

	if (cnt == n) {
		if (check()) {
			result = min(result, priceSum);
		}
		return;
	}
	for (int i = 0; i < book[cnt].second.length(); i++) {
		selectedChar[book[cnt].second[i]-'A']++;
	}
	combination(cnt + 1, priceSum + book[cnt].first);
	for (int i = 0; i < book[cnt].second.length(); i++) {
		selectedChar[book[cnt].second[i]-'A']--;
	}
	combination(cnt + 1, priceSum);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> t >> n;
	for (int i = 0; i < t.length(); i++) {
		tChar[t[i] - 'A']++;
	}
	for (int i = 0; i < n; i++) {
		cin >> book[i].first >> book[i].second;
	}
	
	combination(0,0);
	if (result == 987654321) {
		cout << -1;
	}
	else {
		cout << result;
	}
	return 0;
}
