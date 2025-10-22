public class RearrangeArrayElementsBySign {
    // Brute - Two arrays approach
    // public static int[] rearrangeArray(int[] nums) {
    //     int signed[] = new int[nums.length/2];
    //     int unsigned[] = new int[nums.length/2];
    //     int sidx = 0, uidx = 0;
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] > 0){
    //             unsigned[uidx++] = nums[i];
    //         }else{
    //             signed[sidx++] = nums[i];
    //         }
    //     }
    //     int res[] = new int[nums.length];
    //     int i = 0;
    //     int idx = 0, sdx = 0;
    //     while(i<res.length){
    //         res[i++] = unsigned[idx++];
    //         res[i++] = signed[sdx++];
    //         System.out.println();
    //     }
    //     return res;
    // }

    // Optimized - Single pass approach
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int posIdx = 0, negIdx = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                res[posIdx] = nums[i];
                posIdx += 2;
            }else{
                res[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {3,1,-2,-5,2,-4};
        int res[] = rearrangeArray(nums);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
