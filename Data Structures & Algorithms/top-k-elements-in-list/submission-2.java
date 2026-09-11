class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) map.put(num, 1);
            else map.put(num, count + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        map.entrySet().stream().forEach(entry -> {
            List<Integer> bucket = buckets[entry.getValue()];
            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets[entry.getValue()] = bucket;
            }
            bucket.add(entry.getKey());
        });

        int j = 0, i = nums.length;
        while (j < k) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (int val : bucket) {
                    res[j++] = val;
                    if (j == k) break;
                }
            }
            i--;
        }
        return res;
    }
}
