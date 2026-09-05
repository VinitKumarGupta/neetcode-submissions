class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        // We need three values: i, j & k - so keep space for j and k
        for (int i = 0; i < nums.length - 2; i++) {

            // No possible triplet once the first number itself is positive
            if (nums[i] > 0) break;

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

                    // No need to work on right duplicate values coz they will 
                    // automatically be handled by the conditions we wrote.

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
