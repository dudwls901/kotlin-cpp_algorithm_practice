//www.acmicpc.net/problem/11053
#include<iostream>
#include<algorithm>
using namespace std;

int arr[1001];
int dp[1001];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }
    dp[1] = 1;
    int ans = 1;
    for (int i = 2; i <= n; i++) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr[i] > arr[j]) {
                if (dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;

                    ans = max(ans, dp[i]);
                }

            }
        }
    }
    cout << ans;

    return 0;
}
