class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;          // stores the count of nums != val
        int l = 0, r = 0;

        while (l < nums.length) {
            if (nums[l] != val) {
                k++;
                l++;
                r = l;
            } else {
                // start searching for x != val using right ptr
                if (r < l) r = l;
                while (r < nums.length && nums[r] == val) r++;
                
                if (r < nums.length) {
                    nums[l] = nums[r];
                    nums[r] = val; 
                } else {
                    break;
                }
            }
        }

        return k;
    }
}