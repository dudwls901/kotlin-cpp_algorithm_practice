//https://www.acmicpc.net/problem/18511
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;
string n;
int answer;
string result;
void permutation(vector<int> vt) {
	if (result.length()>0 && stoi(n) >= stoi(result)) {
		answer = max(answer, stoi(result));
	}
	if (result.length() == n.length()) {
		return;
	}
	for (int i = 0; i < vt.size(); i++) {
		result += to_string(vt[i]);
		permutation(vt);
		result.pop_back();
	}
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	
	int k;
	cin >> n >> k;

	vector<int> vt(k);
	for (int i = 0; i < k; i++) {
		cin >> vt[i];
	}
	
	permutation(vt);
	cout << answer;
	return 0;
}
