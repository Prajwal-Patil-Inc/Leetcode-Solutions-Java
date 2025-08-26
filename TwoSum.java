import java.util.HashMap;

public class TwoSum {
    // public int[] twoSum(int[] nums, int target) {
    //     int arr[] = new int[2];
    //     int n = nums.length;
    //     for(int i = 0; i<n; i++){
    //         for (int j = i+1; j < n; j++) {
    //             if(nums[i] + nums[j] == target){
    //                 arr[0] = i;
    //                 arr[1] = j;
    //             }
    //         }
    //     }
    //     return arr;
    // }
    public int[] twoSumOptimized(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target - nums[i])){
                int arr[] = {hm.get(target-nums[i]), i};
                return arr;
            }
            else{
                hm.put(nums[i], i);
            }
        }
        int arr[] = {-1, -1};
        return arr;
    }
    public static void main(String[] args) {
         int nums[] = {2,7,11,15};
         int target = 9;
        //int nums[] = {3, 2, 4};
        //int target = 6;
        TwoSum ts = new TwoSum();
        //int tsum[] = ts.twoSum(nums, target);
        int tsum[] = ts.twoSumOptimized(nums, target);
        for (int i = 0; i <= 1; i++) {
            System.out.print(tsum[i]);
        }
    }
}


// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].