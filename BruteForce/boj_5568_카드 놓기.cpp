//https://www.acmicpc.net/problem/5568
#include <iostream>
#include <string>
#include <unordered_set>
#include <vector>
using namespace std;

int n, k;
//4<=n<=10
//2<=k<=4
unordered_set<string> resultSet;
vector<int> resultVt;
bool visited[10];
void permutation(vector<int> input,int end) {
	if (resultVt.size() == end) {
		string result = "";
		for (int i = 0; i < resultVt.size(); i++) {
			result += to_string(resultVt[i]);
		}
		resultSet.insert(result);
		return;
	}
	for (int i = 0; i < n; i++) {
		if (visited[i]) continue;
		visited[i] = true;
		resultVt.push_back(input[i]);
		permutation(input,end);
		resultVt.pop_back();
		visited[i] = false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> k;
	vector<int> input(n);
	for (int i = 0; i < n; i++) {
		cin>>input[i];
	}
	permutation(input,k);
	cout << resultSet.size();
	return 0;
}
