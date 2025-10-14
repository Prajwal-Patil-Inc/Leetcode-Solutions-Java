import java.util.Collections;
import java.util.Stack;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // public static boolean isPalindrome(ListNode head) {
    //     StringBuilder sb = new StringBuilder();
    //     ListNode curr = head;
    //     while (curr != null) {
    //         sb.append(curr.val);
    //         curr = curr.next;
    //     }
    //     return sb.toString().equals(sb.reverse().toString());
    // }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            stack.push(curr.val);
            curr = curr.next;
        }
        
        Stack<Integer> reverse = (Stack<Integer>) stack.clone();
        Collections.reverse(reverse);
        return stack.equals(reverse);
    }

    public static void main(String[] args) {
        ListNode fourth = new ListNode(1);
        ListNode third = new ListNode(2, fourth);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);

        System.out.println(isPalindrome(head));

    }
}
