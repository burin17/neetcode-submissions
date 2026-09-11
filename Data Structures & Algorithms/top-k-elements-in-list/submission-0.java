class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Arrays.sort(nums);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.count - p2.count);
        int currentNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (currentNum != nums[i]) {
                if (pq.size() == k) {
                    Pair smallest = pq.peek();
                    if (smallest.count < count) {
                        pq.poll(); pq.add(new Pair(currentNum, count));
                    }
                } else {
                    pq.add(new Pair(currentNum, count));
                }
                currentNum = nums[i]; count = 1;
            } else {
                count++;
            }
        }
        if (pq.size() == k) {
            Pair smallest = pq.peek();
            if (smallest.count < count) {
                pq.poll(); pq.add(new Pair(currentNum, count));
            }
        } else {
            pq.add(new Pair(currentNum, count));
        }
        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll().num;
        }
        return res;
    }
}

class Pair {
    int num;
    int count;
    Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}