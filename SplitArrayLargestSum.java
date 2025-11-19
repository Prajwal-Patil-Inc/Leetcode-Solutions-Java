public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int left = 0; //Max of array
        int right = 0; //Sum of array
        for (int i : nums) {
            left = Math.max(left, i);
            right += i;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canWeSplit(nums, mid) <= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    //Get the number of splits using the curr Max Splits
    public static int canWeSplit(int[] nums, int currMaxSplit){
        int splits = 1, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //If the current number + next is less than the maxSplits
            if(currSum + nums[i] <= currMaxSplit){
                currSum += nums[i];
            }else{
                splits++;
                currSum = nums[i];
            }
        } 
        return splits;
    }
    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8}; int k = 2;
        System.out.println(splitArray(nums, k));
    }
}
