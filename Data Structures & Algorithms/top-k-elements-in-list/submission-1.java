class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) map.put(num, 1);
            else map.put(num, count + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue()).toList();
        for (int i = 0; i < k; ++i) {
            res[i] = entries.get(entries.size() - 1 - i).getKey();
        }
        return res;
    }
}
