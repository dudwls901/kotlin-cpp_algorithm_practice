//https://leetcode.com/problems/contains-duplicate/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return set.size() != nums.length;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++ ){
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
