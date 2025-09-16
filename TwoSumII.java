import java.util.HashMap;

public class TwoSumII {
    
    public static int[] calculateTwoSumsII(int[] nums, int target){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(hmap.containsKey(target - nums[i])){
                int arr[] = {hmap.get(target - nums[i]), i+1};
                return arr;
            }
            else{
                hmap.put(nums[i], i+1);
            }
        }
        int arr[] = {-1,-1};
        return arr;
    }

    public static int[] calculateTwoSumsIITwoPointers(int[] nums, int target){
        //Using two pointers
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] == target){
                return new int[]{l+1, r+1};
            }
            if(nums[l] + nums[r] < target){
                l++;
            }else{
                r++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4};
        int target = 9;
        // int result[] = calculateTwoSumsII(nums, target);
        int result[] = calculateTwoSumsIITwoPointers(nums, target);
        for (int i : result) {
            System.out.print(i+ " ");
        }
    }

}
