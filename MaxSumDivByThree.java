public class MaxSumDivByThree {
     // Brute -> backtracking and finding the sum
    // static int maxSum = 0;

    // public static int maxSumDivThree(int[] nums){
    //     backtrack(nums, 0, 0);
    //     return maxSum;
    // }

    // public static void backtrack(int[] nums, int index, int currSum){
    //     if(index == nums.length){
    //         if(currSum % 3 == 0){
    //             maxSum = Math.max(maxSum, currSum);
    //         }
    //         return;
    //     }

    //     backtrack(nums, index+1, currSum+nums[index]); //include current number

    //     backtrack(nums, index+1, currSum); //exclude current number
    // }

    //Optimized -> Every number leaves a remainder 0, 1, 2 when divided by 3, 
    // So we want to keep track of the maximum sums we can form for each remainder at every step
    public static int maxSumDivThree(int[] nums){
        int dp[] = new int[3];

        for(int i : nums){
            int[] temp = dp.clone(); //copy of the previous state of dp
            for(int r=0; r<3; r++){ //r -> remainder
                int newSum = temp[r] + i; //Previous sum + current num
                dp[newSum % 3] = Math.max(dp[newSum % 3], newSum);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        // int[] nums = {4};
        System.out.println(maxSumDivThree(nums));
    }
}
