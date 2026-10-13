class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < res.length; ++i) {
            res[i] = product;
            product *= nums[i];
        }
        int suffixProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return res;
    }
}  
