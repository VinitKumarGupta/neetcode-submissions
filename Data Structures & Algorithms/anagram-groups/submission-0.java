class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            int[] freq = new int[26];

            // create alphabet frequency array for each string i
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
