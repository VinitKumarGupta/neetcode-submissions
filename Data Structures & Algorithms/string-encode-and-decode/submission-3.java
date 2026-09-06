class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length() + "@" + str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(i) != '@') i++;

            int n = Integer.parseInt(str.substring(j, i));

            res.add(str.substring(i + 1, i + n + 1));

            i = i + n + 1;
        }

        return res;
    }
}
