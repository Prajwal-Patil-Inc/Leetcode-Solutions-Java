import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int maxLength = 0;

        for(int num : set){
            //Only count forward if this is the beginning of the sequence
            if(!set.contains(num - 1)){
                int currNum = num;
                int currLen = 1;
                while(set.contains(currNum + 1)){
                    currNum++;
                    currLen++;
                }
                maxLength = Math.max(maxLength, currLen);
            }
        }
        return maxLength;

        // HashMap<Integer, Boolean> hMap = new HashMap<>();
        // for(int i : nums){
        //     hMap.put(i, Boolean.FALSE);
        // }
        // int maxLength = 0;

        // for(int i : nums){
        //     int count = 1;

        //     int nextNum = i + 1;
        //     //greater - right
        //     while(hMap.containsKey(nextNum) && !hMap.get(nextNum)){
        //         hMap.put(nextNum, Boolean.TRUE);
        //         count++;
        //         nextNum++;
        //     }

        //     int prevNum = i - 1;
        //     //smaller - left
        //     while(hMap.containsKey(prevNum) && !hMap.get(prevNum)){
        //         hMap.put(prevNum, Boolean.TRUE);
        //         count++;
        //         prevNum--;
        //     }
        //     maxLength = Math.max(count, maxLength);
        // }
        // return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
