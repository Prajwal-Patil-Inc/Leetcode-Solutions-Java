public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums){

        int n = nums.length;
        int[] left_arr = new int [n];
        int[] right_arr = new int[n];

        int[] product = new int[n];

        left_arr[0] = 1;
        right_arr[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left_arr[i] = nums[i-1] * left_arr[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            right_arr[i] = nums[i+1] * right_arr[i+1];  
        }
        for (int i = 0; i < n; i++) {
            product[i] = left_arr[i] * right_arr[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int res[] = productExceptSelf(nums);
        System.out.println();
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
