import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    // Brute - O(N^2), O(N)
    // public static boolean check(int[] nums) {
    //     int sorted[] = nums.clone();
    //     Arrays.sort(sorted);
    //     int rotated[] = new int[sorted.length];
    //     int x = 1;
    //     while(x <= nums.length){
    //         for(int i=0; i<rotated.length; i++){
    //             rotated[i] = sorted[(i+x) % sorted.length];        
    //         }
    //         if(Arrays.equals(rotated, nums)){
    //             return true;
    //         }
    //         x++;
    //     }
    //     return false;
    // }

    // Optimized - O(N), O(1)
    // Sorted array me numbers chhote se bade jaate hain.
    // To jab hum rotate karte hain, to ek jagah aisi milegi jahan bada number chhote number se pehle aayega.
    // Jaise yahan:
    // [3, 4, 5, 1, 2]
    // → 5 ke baad 1 aata hai — yahi “drop” point hai.

    // Agar sirf ek hi drop mile, to array sorted and rotated hai.
    // Agar 2 ya zyada drops mil gaye, matlab ye kisi sorted array ko rotate karke nahi bana sakte.

    public static boolean check(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                count++;
            }
        }
        return count <= 1 ? true : false;
    }

    public static void main(String[] args) {
        int nums[] = {3,4,5,1,2};
        System.out.println(check(nums));
    }
}
