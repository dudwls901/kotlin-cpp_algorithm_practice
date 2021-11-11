//https://www.acmicpc.net/problem/2217
#include <iostream>
#include <algorithm>
using namespace std;
int n;
//1<=n<=100000
int input[100000];
int answer;
int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> input[i];
	}
	sort(input, input + n);
	for (int i = 0; i < n; i++) {
		answer = max(answer, (n - i)*input[i]);
	}
	cout << answer;


	return 0;
}
