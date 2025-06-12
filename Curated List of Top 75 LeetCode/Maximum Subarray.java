//https://leetcode.com/problems/maximum-subarray/description/
//dp
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int answer = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}

//divide and conquer
class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    private int maxSubArraySum(int[] nums, int s, int e) {
        if (s > e) return Integer.MAX_VALUE;
        if (s == e) return nums[s];
        int mid = (s + e) / 2;
        int leftSum = nums[mid];
        int rightSum = nums[mid+1];
        int curSum = nums[mid];
        for (int i = mid-1; i >= s; i--) { 
            curSum += nums[i];
            leftSum = Math.max(leftSum, curSum);
        }
        curSum = nums[mid+1];
        for (int i = mid + 2; i <= e; i++) {
            curSum += nums[i];
            rightSum = Math.max(rightSum, curSum);
        }
        return Math.max(Math.max(maxSubArraySum(nums, s, mid), maxSubArraySum(nums, mid+1, e)), leftSum + rightSum);
    }
}
