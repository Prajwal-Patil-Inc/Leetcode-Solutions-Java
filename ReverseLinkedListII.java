
public class ReverseLinkedListII {

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node and make it point to the head.. basically (Dummy -> 1 -> 2...)
        ListNode dummy = new ListNode(0);
        dummy.next = head; //make it point to head

        ListNode prevLeft = dummy; //Prev node to left
        ListNode curr = head;

        //Moving pointers to proper locations
        for(int i=0; i<left-1; i++){
            prevLeft = prevLeft.next; //Point to one node before left
            curr = curr.next; //point to left
        }

        ListNode leftNode = curr; //Store leftnode to rearrange list later
        ListNode prev = null; //Point the prev to null

        // Normal reveres algo
        for(int i=0; i<(right - left + 1); i++){
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        prevLeft.next = prev;   //Make the prevLeft point to start of the new reversed list
        leftNode.next = curr;   //Rearrange the list

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);

        int left = 2, right = 4;

        ListNode resHead = (reverseBetween(head, left, right));

        while (resHead != null) {
            System.out.print(resHead.val + "->");
            resHead = resHead.next;
        }


    }

}
