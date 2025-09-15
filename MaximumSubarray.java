public class MaximumSubarray {
    
    public static int calculateMaximumSubarray(int[] nums){
        int n = nums.length;
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while(j<n){
            sum += nums[j];
            max_sum = Math.max(max_sum, sum);
            if(sum < 0){
                sum = 0;
                i++;
            }
            j++;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(calculateMaximumSubarray(nums));

    }

}
