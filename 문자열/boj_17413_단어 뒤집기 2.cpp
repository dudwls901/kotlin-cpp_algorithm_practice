//https://www.acmicpc.net/problem/17413
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	string input;
	getline(cin, input);
	char tag = '>';
	string word = "";
	string answer = "";
	for (int i = 0; i < input.length(); i++) {
		char ch = input[i];
		//태그가 열려 있을때
		if (tag == '<') {
			if (ch == '>') {
				tag = '>';
			}
			answer += ch;
		}
		//태그가 닫혀 있을때
		else {
			if (ch == '<') {
				tag = '<';
				if (word.length() != 0) {
					for (int j = word.length() - 1; j >= 0; j--) {
						answer += word[j];
					}
					word = "";
				}
				answer += ch;
			}
			else if (ch == ' ') {
				if (word.length() != 0) {
					for (int j = word.length() - 1; j >= 0; j--) {
						answer += word[j];
					}
					word = "";
					answer += ' ';
				}
			}
			else {
				if (ch != '>') {
					word += ch;
				}
			}
			
		}
	}
	if (word.length() != 0) {
		for (int j = word.length() - 1; j >= 0; j--) {
			answer += word[j];
		}
	}
	cout << answer;
	return 0;
}


