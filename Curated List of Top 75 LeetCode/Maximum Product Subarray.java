//https://leetcode.com/problems/maximum-product-subarray/description/
//dp
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] minDp = new int[n];
        int[] maxDp = new int[n];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        int answer = maxDp[0];
        for (int i = 1; i < n; i++){
            int num = nums[i];
            minDp[i] = Math.min(num, Math.min(minDp[i-1] * num, maxDp[i-1] * num));
            maxDp[i] = Math.max(num, Math.max(maxDp[i-1] * num, minDp[i-1] * num));
            answer = Math.max(answer, maxDp[i]);
        }
        return answer;
    }
}
