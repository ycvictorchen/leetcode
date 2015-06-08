/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prv = head;
        ListNode cur = prv.next;
        ListNode dum = new ListNode(0);
        dum.next = head;
        while (cur != null) {
            ListNode p = dum;
            while (p != prv && p.next.val <= cur.val) {
                p = p.next;
            }
            if (p == prv) {
                prv = cur;
                cur = cur.next;
            }
            else {
                prv.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = prv.next;
            }
        }
        return dum.next;
    }
}