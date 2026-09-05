class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Binary search is the key, 
        // since we need to return values and not index
        // we can sort the array first.
        Arrays.sort(nums);

        // We need three values: i, j & k - so keep space for j and k
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;              // left pointer
            int k = nums.length - 1;    // right pointer

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // since we now added these numbers in our res list
                    // we don't want duplicate values to appear in the second entry

                    // skip duplicate left values
                    while (j < k && nums[j] == nums[j - 1]) j++;

                    // No need to work on right values coz they will automatically
                    // be handled by the conditions we wrote at bottom

                } else if (sum > 0) {
                    // sum is greater than zero, means we need to include smaller values
                    k--;                    
                } else {
                    // sum is less than zero, means we need to include larger values
                    j++;
                }
            }

        }

        return res;
    }
}
