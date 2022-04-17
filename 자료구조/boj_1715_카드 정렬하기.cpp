//https://www.acmicpc.net/problem/1715
#include<iostream>
#include<queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(0);
	
	priority_queue<int,vector<int>,greater<int>> pq;
	int n;
	int ans=0;
	cin >> n;
    if(n==1){
        cout <<0;
        return 0;
    }
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		pq.push(a);
	}
	
	while (!pq.empty()) {
		int sum = 0;
		sum += pq.top();
		pq.pop();
		if (!pq.empty()) {
			sum += pq.top();
			pq.pop();
			if(!pq.empty())
			pq.push(sum);
		}

		ans += sum;
	}

	cout << ans;


	return 0;
}
