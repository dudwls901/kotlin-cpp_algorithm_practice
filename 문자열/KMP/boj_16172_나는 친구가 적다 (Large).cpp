//https://www.acmicpc.net/problem/16172
#include <iostream>
#include <vector>
using namespace std;

vector<int> makeTable(string pattern) {
	vector<int> table(pattern.length(), 0);
	int j = 0;
	for (int i = 1; i < table.size(); i++) {
		while (j > 0 && pattern[i] != pattern[j]) {
			j = table[j - 1];
		}
		if (pattern[i] == pattern[j]) {
			table[i] = ++j;
		}
	}
	return table;
}

bool kmp(vector<int> &table, string pattern, string parent) {
	int j = 0;
	for (int i = 0; i < parent.size(); i++) {
		while (j > 0 && parent[i] != pattern[j]) {
			j = table[j - 1];
		}
		if (parent[i] == pattern[j]) {
			if (j == pattern.size() - 1) {
				return 1;
			}
			else {
				j++;
			}
		}
	}
	return 0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	string input,pattern;
	cin >> input>>pattern;
	string parent = "";
	for (int i = 0; i < input.length(); i++) {
		if (isalpha(input[i])) {
			parent += input[i];
		}
	}
	vector<int> table = makeTable(pattern);

	cout << kmp(table, pattern, parent) ? 1 : 0;
	return 0;
}
