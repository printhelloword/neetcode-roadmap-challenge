package linkedlist;

public class ReverseALinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode reversed = reverseList(node);

        ListNode current = reversed;
        while (current != null) {
            System.out.println(current.val);
            System.out.println();
            current = current.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;      
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
}
