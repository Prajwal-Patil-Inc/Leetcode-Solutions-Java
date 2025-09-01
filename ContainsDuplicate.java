/*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Input: nums = [1,2,3,1]

Output: true */

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num);
        }
        return false; // No duplicates
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
}
