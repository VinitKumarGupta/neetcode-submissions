class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int water = -1;
        int left = 0, right = n - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(heights[left], heights[right]);

            water = Math.max(water, w * h);

            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return water;
    }
}
