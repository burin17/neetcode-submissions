class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            suffixSum[i] = product;
            product *= nums[i];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            output[i] = prefixSum[i] * suffixSum[i];
        }
        return output;
    }
}  
