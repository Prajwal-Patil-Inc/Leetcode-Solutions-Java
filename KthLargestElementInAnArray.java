import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) { //Adding elements in the PQ only upto the kth element
            q.add(nums[i]);             
        }        
        for(int i=k; i<nums.length; i++){
            if(q.peek() < nums[i]){ //If the first element in the pq is smaller than the nums[i] element
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }
    
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4}; 
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}

//To find the kth smallest element in the array, just add Collections.reverseOrder() and q.peek() > nums[i]