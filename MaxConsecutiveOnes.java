public class MaxConsecutiveOnes {
    // Sliding window - O(N), O(1)
    public static int findMaxConsecutiveOnes(int[] nums) {  
        int res = 0;
        int i=0, j=1;
        while(j<nums.length){
            if(nums[i] == 1 && nums[j] == 1){
                res = Math.max(j - i + 1, res);
                j++;
            }else{
                i = ++j;
            }
        }
        return res;
    }

    // One pass - O(N), O(1)
    // public static int findMaxConsecutiveOnes(int[] nums) {
    //     int res = 0;
    //     int count = 0;
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] == 1){
    //             count++;
    //         }else{
    //             res = Math.max(res, count);
    //             count = 0;
    //         }
    //     }
    //     return Math.max(res, count);
    // }

    public static void main(String[] args) {
        // int nums1[] = {1,1,0,1,1,1};
        int nums1[] = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums1));
    }
}
