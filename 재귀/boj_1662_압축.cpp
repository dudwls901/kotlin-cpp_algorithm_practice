//https://www.acmicpc.net/problem/1662
#include <iostream>
#include <string>

using namespace std;
string str;
bool visited[50];
int recur(int idx) {
	int cnt = 0;
	for (int i = idx; i < str.length(); i++) {
		char ch = str[i];
		//open
		if (ch == '('&&!visited[i]) {
			visited[i] = true;
			cnt--;
			cnt += (int)(str[i - 1] - '0') * recur(i+1);
		}
		//close
		else if (ch == ')'&& !visited[i]) {
			visited[i] = true;
			return cnt;
		}
		//num
		else if(!visited[i]) {
			visited[i] = true;
			cnt++;
		}
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	
	cin >> str;
	cout << recur(0);


	return 0;
}
