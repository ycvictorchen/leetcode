/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode ln = l3;
        int carryOver = 0;
        while (l1 != null || l2 != null || carryOver > 0) {
            int t = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carryOver;
            ln.next = new ListNode(t % 10);
            carryOver = t / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            ln = ln.next;
        }
        return l3.next;
    }
}