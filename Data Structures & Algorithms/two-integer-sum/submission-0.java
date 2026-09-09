class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Integer idx1 = map.get(target - num);
            if (idx1 == null) {
                map.put(num, i);
            } else {
                return new int[]{idx1, i};
            }
        }
        return null;
    }
}
