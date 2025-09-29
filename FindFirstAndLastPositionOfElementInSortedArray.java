public class FindFirstAndLastPositionOfElementInSortedArray {
    // Brute
    // public static int[] searchRange(int[] nums, int target) {
    //     int firstIndex = -1, lastIndex = -1;
    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i] == target && firstIndex == -1){
    //             firstIndex = i;
    //             lastIndex = i;
    //         }else if(nums[i] == target && firstIndex != -1){
    //             lastIndex = i;
    //         }
    //     }
    //     return firstIndex == -1 ? new int[]{-1,-1} : new int[]{firstIndex, lastIndex};
    // }

    // Binary Search
    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = -1, lastIndex = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]  == target){
                if(mid != 0 && nums[mid - 1] == target){
                    right = mid - 1;
                }else{
                    firstIndex = mid;
                    break;
                }
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        left = 0; right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]  == target){
                if(mid != nums.length - 1 && nums[mid + 1] == target){
                    left = mid + 1;
                }else{
                    lastIndex = mid;
                    break;
                }
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return firstIndex == -1 ? new int[]{-1,-1} : new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};  
        int target = 8;
        // int nums[] = {1,2,2,2,2,3,4};
        // int target = 2;
        // int nums[] = {1};
        // int target = 1;
        int[] res = searchRange(nums, target);

        for(int i : res){
            System.out.print(i+" ");
        }
    }
}
