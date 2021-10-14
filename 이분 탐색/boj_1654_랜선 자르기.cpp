//https://www.acmicpc.net/problem/1654
#include<iostream>
#include<algorithm>
using namespace std;

//n개 이상 만들기
//기존 길이가 제각각인 k개의 랜선을 잘라서 n개의 같은 길이 랜선으로 만들기
//최대 랜선 길이
//1<=k<=10000
//1<=n<=1000000
//k<=n
//k랜선의 길이는 항상 2^31-1이하 자연수
//길이 최소 1 길이 최대 
int k, n;
long long input[10000];
long long result = 0;

int cnt(int len) {
	int count = 0;
	for (int i = 0; i < k; i++) {
		count += input[i] / len;
	}
	return count;
}

void biSearch(long long start,long long end) {
	
	if (start >= end) {
		return;
	}
	long long mid = (start + end) / 2;
	cout << mid << '\n';
	int count = cnt(mid);
	if (count < n) {
		biSearch(start, mid);
	}
	else {
		result = max(result, mid);
		biSearch(mid + 1, end);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> k >> n;
	long long maxLen = 0;
	for (int i = 0; i < k; i++) {
		cin >> input[i];
		maxLen = max(maxLen, input[i]);
	}
	biSearch(1, maxLen+1);
	cout << result;
	return 0;
}
