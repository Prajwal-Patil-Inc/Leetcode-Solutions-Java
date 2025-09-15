public class MaximumSizeSubarraySizeK {
    public static int maxSubArray(int[] nums, int k) {
        int l=0, r=0;
        int sum=0;
        int maxSum = Integer.MIN_VALUE;
        while(r < nums.length){
            sum += nums[r];
            if((r - l + 1) < k){
                r++;
            }else if((r - l + 1)==k){
                maxSum = Math.max(maxSum, sum);
                sum -= nums[l];
                l++;
                r++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        // int nums[] = {1, 4, 2, 10, 2, 3, 1, 0, 20}; int k = 4;
        int nums[] = {100,200,300, 400};
        int k = 2;
        System.out.println(maxSubArray(nums, k));
    }
}
