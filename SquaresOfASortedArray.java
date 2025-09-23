import java.util.Arrays;

public class SquaresOfASortedArray {
    //Brute Force
    // public static int[] sortedSquares(int[] nums) {
    //     int n = nums.length;
    //     int res[] = new int[n];
    //     int i = 0;
    //     for (int num : nums) {
    //         res[i] = num * num;
    //         i++; 
    //     }
    //     Arrays.sort(res);
    //     return res;
    // }

    //Optimized
    // public static int[] sortedSquares(int[] nums) {
    //     int n = nums.length;
    //     int res[] = new int[n];

    //     //Square em up
    //     for(int i=0; i<n; i++){
    //         nums[i] *= nums[i];
    //     }

    //     //Two pointers
    //     int left = 0;
    //     int right = n-1;

    //     for(int i=n-1; i>=0; i--){
    //         if(nums[left] > nums[right]){
    //             res[i] = nums[left];
    //             left++;
    //         }else{
    //             res[i] = nums[right];
    //             right--;
    //         }
    //     }
    //     return res;
    // }

    //Further Optimized
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        //Two pointers
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[i] = nums[left] * nums[left];
                left++;
            }
            else{
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        // int nums[] = {-4,-1,0,3,10};
        int nums[] = {-7,-3,2,3,11};
        int res[] = sortedSquares(nums);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
