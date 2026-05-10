class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int times = (int) Math.floor(n / 2) + 1;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) >= times) return num;
        }

        return -1;
    }
}