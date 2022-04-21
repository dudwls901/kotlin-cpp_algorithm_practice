//https://www.acmicpc.net/problem/1025
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <math.h>
using namespace std;
int n, m, answer = -1;//n ==r m//c
vector<string> input;

int toSquare(int num) {
	int squareRoot = sqrt(num);
	if(squareRoot*squareRoot==num)
		return num;
	else 
		return - 1;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	cin >> n >> m; 

	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		input.push_back(str);
	}
	for (int r = 0; r < n; r++) {
		for (int c = 0; c < m; c++) {
			for (int dr = -n + 1; dr < n; dr++) {
				for (int dc = -m + 1; dc < m; dc++) {
					if (dr == 0 && dc == 0)
						continue;
					int a = r, b = c;
					string str="";
					while (a >= 0 && a < n && b >= 0 && b < m) {
						str += input[a][b];
						answer = max(answer,toSquare(stoi(str)));
						a += dr;
						b += dc;
					}
				}
			}
		}
	}
	if (n == 1 && m == 1) {
		cout <<toSquare(input[0][0]-'0');
	}
	else
	cout << answer;

}
