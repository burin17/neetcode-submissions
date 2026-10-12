class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        int countOfZero = 0;
        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                countOfZero++;
            }
        }
        int[] output = new int[nums.length];
        if (countOfZero > 1) {
            return output;
        }
        for (int i = 0; i < output.length; ++i) {
            if (nums[i] == 0) {
                output[i] = (int) product;
            } else if (countOfZero != 1) {
                output[i] = (int) (product / nums[i]);
            }
        }
        return output;
    }
}  
