class Solution {
    // Space O(n)
    // Runtime O(n)
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> viewed = new HashSet<>();

        for (int i : nums) {
            if (viewed.contains(i)) {
                return true;
            } else {
                viewed.add(i);
            }
        }

        return false;
    }
}