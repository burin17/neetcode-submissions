class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            minHeap.add(new int[]{num, freq});
            if (minHeap.size() > k) minHeap.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
