#include<iostream>
#include<vector>
#include <string>
using namespace std;
char arr[5] = { 'a','b','c','d','e'};
vector<char> vt;
bool check[5];

void permutation(int start, int end) {
	
	if (start == end) {
		for (int i = 0; i < vt.size(); i++) {
			cout << vt[i] << ' ';
		}
		cout << '\n';
		return;
	}
	else {
		for (int i = 0; i < sizeof(arr); i++) {
			if (check[i])
				continue;
			check[i] = true;
			vt.push_back(arr[i]);
			permutation(start + 1, end);
			vt.pop_back();
			check[i] = false;
	}
	}

}

void combination(int idx, int start, int end) {
	if (start == end) {
		for (int i = 0; i < vt.size(); i++) {
			cout << vt[i] << ' ';
		}
		cout << '\n';
		return;
	}
	else {
		for (int i = idx; i < 5; i++) {
			if (check[i])
				continue;
			vt.push_back(arr[i]);
			combination(i+1,start + 1, end);
			vt.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cout << "permutation" << '\n';
	permutation(0,2);
	vt.clear();
	cout << "combination" << '\n';
	
	combination(0,0,2);
	return 0;
}
