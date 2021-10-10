//https://www.acmicpc.net/problem/1991
#include <iostream>
#include <vector>
using namespace std;

int n;
pair<int,int> edge[26];
void pre(char cur) {
	//root left right
	if (cur == '.')return;
	
	cout << cur;
	pre(edge[cur - 'A'].first);
	pre(edge[cur - 'A'].second);
}


void in(char cur) {
	//left root right
	if (cur == '.')return;
	in(edge[cur - 'A'].first);
	cout << cur;
	in(edge[cur - 'A'].second);
}

void post(char cur) {
	//left right root
	if (cur == '.') return;
	post(edge[cur - 'A'].first);
	post(edge[cur - 'A'].second);
	cout << cur;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		char ch,left,right;
		cin >> ch >> left >> right;
		edge[ch - 'A'] = { left,right };
	}
	pre('A');
	cout << '\n';
	in('A');
	cout << '\n';
	post('A');

	 return 0;
}
