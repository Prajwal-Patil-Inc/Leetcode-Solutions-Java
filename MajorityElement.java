import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i : nums){
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }
        for(int i : hmap.keySet()){
            if(hmap.get(i) > (nums.length/2)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}
