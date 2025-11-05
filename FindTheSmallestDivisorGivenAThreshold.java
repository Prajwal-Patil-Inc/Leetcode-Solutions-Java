public class FindTheSmallestDivisorGivenAThreshold {
    // public static int smallestDivisor(int[] nums, int threshold) {
    //     int smallest = Integer.MAX_VALUE;
    //     int min = 1, max = 0;

    //     for (int i : nums) {
    //         min = Math.min(i, min);
    //         max = Math.max(i, max);
    //     }

    //     int res = Integer.MAX_VALUE;
    //     for (int i = min; i <= max; i++) {
    //         int sum = 0;
    //         for (int j = 0; j < nums.length; j++) {
    //             double div = Math.ceil((double)nums[j]/i);
    //             sum += div;
    //         }
    //         smallest = Math.min(smallest, sum);
    //         if(smallest <= threshold){
    //             res = Math.min(res, i);
    //         }
    //     }
    //     return res;
    // }

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;

        for (int i : nums) {
            left = Math.min(i, left);
            right = Math.max(i, right);
        }

        while(left <= right){
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int i : nums) {
                double div = Math.ceil((double)i/mid);
                sum += div;
            }
            if(sum <= threshold){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,5,9}; int threshold = 6;
        // int[] nums = {44,22,33,11,1}; int threshold = 5;
        int[] nums = {2,3,5,7}; int threshold = 8;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
