/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dum = new ListNode(0);
        ListNode par = dum;
        ListNode prv = dum;
        ListNode cur = head;
        dum.next = head;
        while (cur != null) {
            if (par != prv && cur.val < x) {
                prv.next = cur.next;
                cur.next = par.next;
                par.next = cur;
                par = par.next;
                cur = prv.next;
            }
            else {
                if (cur.val < x) {
                    par = par.next;
                }
                prv = cur;
                cur = cur.next;
            }
        }
        return dum.next;
    }
}