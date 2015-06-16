/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nA = headA;
        ListNode nB = headB;
        while (true) {
            if (nA == nB) {
                return nA;
            }
            ListNode tA = nA.next;
            ListNode tB = nB.next;
            nA = tA == null && tB != null ? headB : tA;
            nB = tB == null && tA != null ? headA : tB;
        }
    }
}