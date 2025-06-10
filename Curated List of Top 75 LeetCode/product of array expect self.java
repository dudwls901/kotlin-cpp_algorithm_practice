//https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 0; i < n; i++) {
            answer[i] *= product;
            product *= nums[i];
        }
        product = 1;
        for (int i = n-1; i >=0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }
        return answer;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCnt = 0;
        int productTotal = 0;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                if (productTotal == 0) {
                    productTotal += nums[i];
                } else {
                    productTotal *= nums[i];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCnt > 1) {
                answer[i] = 0;
            } else {
                if (nums[i] == 0) {
                    answer[i] = productTotal;
                } else {
                    if(zeroCnt > 0) answer[i] = 0;
                    else answer[i] = productTotal / nums[i];
                }
            }
        }
        return answer;
    }
}
