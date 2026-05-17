class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Store each number and its frequency as:
        // [number, frequency]
        List<List<Integer>> freq = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq.add(List.of(entry.getKey(), entry.getValue()));
        }

        // Sort by frequency in descending order
        freq.sort((a, b) -> Integer.compare(b.get(1), a.get(1)));

        // Extract the first k most frequent numbers
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = freq.get(i).get(0);
        }

        return res;
    }
}