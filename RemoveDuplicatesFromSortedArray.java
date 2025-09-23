public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int unique = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[++unique] = nums[i];
            }
        }
        return unique + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
