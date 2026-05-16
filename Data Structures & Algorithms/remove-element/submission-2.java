class Solution {
    public int removeElement(int[] nums, int val) {
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != val) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }

        return writeIdx;
    }
}