class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        // add all elements of nums to this set (handles duplicates)
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;  // handles empty array edge case

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currStreak = 0;

                int currNum = num;
                while (numSet.contains(currNum)) {
                    currStreak++;
                    currNum++;      // that's why we stored it first
                }

                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;
    }
}
