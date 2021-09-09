//https://www.acmicpc.net/problem/5052
#include <iostream>
#include <string>
#include <vector>

using namespace std;

char input[10000][11];

struct TRIE {
	
	bool Finish;
	TRIE *Node[10];
	TRIE() {
		Finish = false;
		for (int i = 0; i < 10; i++) {
			Node[i] = NULL;
		}
	}

	void insert(char *str) {
		if (*str == '\0') {
			Finish = true;
			return;
		}
		int Cur = *str - '0';
		if (Node[Cur] == NULL) Node[Cur] = new TRIE();
		Node[Cur]->insert(str + 1);
	}

	bool find(char *str) {
		//끝까지 도달한 경우는 상관 없음//중간에 finish가 없었기 때문
		if (*str == '\0') {
			return false;
		}
		//중간에 finish가 있으면
		if (Finish == true)
			return true;

		int Cur = *str - '0';
		if (Node[Cur] == NULL) return false;
		return Node[Cur]->find(str + 1);
	}


};


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	

	int t, n;
	cin >> t;
	while (t--) {
		cin >> n;
		TRIE *Root = new TRIE();
		for (int i = 0; i < n; i++) {
			cin >> input[i];
			//cout <<i<<' '<< input[i] << '\n';
			Root->insert(input[i]);
		}
		int i;
		for(i=0; i<n;i++){
			if (Root->find(input[i])) {
				cout << "NO\n";
				break;
			}
		}
		if (i == n)
			cout << "YES\n";
	}



	return 0;
}
