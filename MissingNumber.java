/*
 * Find the missing number in the array -> [3,0,1] -> missing is 2
 * 
 */

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {
    // Brute - O(nlogn), O(n);
    // public static int missingNumber(int[] nums){
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     for(int i=0; i<=n; i++){
    //         if(i< n && i != nums[i]){
    //             return i;
    //         }else if(i == n){
    //             return n;
    //         }
    //     }
    //     return -1;
    // }
    // Using Hashset - O(N), O(N)
    // public static int missingNumber(int[] nums){
    //     HashSet<Integer> hset = new HashSet<>();
    //     for (int i : nums) {
    //         hset.add(i);
    //     }
    //     int expectedNums = nums.length + 1;
    //     for(int i=0; i<=expectedNums; i++){
    //         if(!hset.contains(i)){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // Using Guass's formula -> expectedSum = nums.length * ( nums.length + 1 ) / 2
    // O(N), O(1)
    public static int missingNumber(int[] nums){
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    } 
}
