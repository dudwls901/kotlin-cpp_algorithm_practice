//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int answer = Integer.MAX_VALUE;
        while (s <= e) {
            int left = (s + e) / 2;
            if (nums[left] > nums[e])
                s = left + 1;
            else
                e = left - 1;
            answer = Math.min(answer, nums[left]);
        }
        return answer;
    }
}
