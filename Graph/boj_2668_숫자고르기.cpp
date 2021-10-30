//https://www.acmicpc.net/problem/2668
#include <iostream>
#include <vector>
#include <set>
#include <cstring>
using namespace std;


//1<=n<=100
int n;
int input[101];
bool visited[101];
set<int> answer;
bool isRight;
void dfs(int firstNum,int num) {	
	if (visited[num]) {
		if (firstNum == num) {
				isRight = true;
				answer.insert(num);
		}
		return;
	}
	visited[num] = true;
	dfs(firstNum,input[num]);
	if (isRight) {
		answer.insert(num);
		answer.insert(input[num]);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> input[i];
	}
	for (int i = 1; i <= n; i++) {
		visited[i] = true;
		dfs(i,input[i]);
		memset(visited, false, 101);
		isRight = false;
	}
	cout << answer.size() << '\n';
	for (auto o : answer) {
		cout << o << '\n';
	}
	return 0;
}
