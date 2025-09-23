import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        //Loop till last third element so that we still have two elements left in the last iteration of the loop
        for(int i=0; i<nums.length-2; i++){
            //Two pointers
            int left = i + 1;
            int right = nums.length - 1; //on the last element of the array
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } 
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
