/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return this.mergeKLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeKLists(ListNode[] lists, int i, int j) {
        if (i >= j) {
            return lists[i];
        }
        int m = (i + j) / 2;
        return this.mergeTwoLists(
            this.mergeKLists(lists, i, m),
            this.mergeKLists(lists, m + 1, j)
        );
    }
    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode h = new ListNode(0);
        ListNode n = h;
        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null && n1.val < n2.val || n2 == null) {
                n.next = n1;
                n = n.next;
                n1 = n1.next;
            }
            else {
                n.next = n2;
                n = n.next;
                n2 = n2.next;
            }
        }
        return h.next;
    }
}