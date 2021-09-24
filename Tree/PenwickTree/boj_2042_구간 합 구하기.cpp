//https://www.acmicpc.net/problem/2042
#include <iostream>
#include <vector>
#include <math.h>
#include <algorithm>


using namespace std;
int n, m, k;
//1<=n<=1000000
//1<=m,k<=10000


void updatePenwickTree(vector<long long> &penwickTree, int node, long long value) {

	while (node < penwickTree.size()) {
		penwickTree[node] = penwickTree[node] + value;
		node = node + (node & -node);
	}
}

long long sumPenwickTree(vector<long long> &penwickTree, int node) {
	long long sum = 0;
	while (node != 0) {
		sum += penwickTree[node];
		node = node - (node & -node);
	}

	return sum;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m >> k;
	vector<long long> penwickTree(n + 1);
	for (int i = 1; i <= n; i++) {
		int value;
		cin >> value;
		updatePenwickTree(penwickTree, i, value);
	}
	
	for (int i = 0; i < m + k; i++) {
		int order, left;
		long long right;
		cin >> order >> left >> right;
		if (order == 1) {
			//change
			updatePenwickTree(penwickTree, left, right-(sumPenwickTree(penwickTree, left) - sumPenwickTree(penwickTree, left - 1)));
			
		}
		else {
			//sum
			cout << sumPenwickTree(penwickTree, right)-sumPenwickTree(penwickTree,left-1)<<'\n';
		}
	}
	return 0;
}
