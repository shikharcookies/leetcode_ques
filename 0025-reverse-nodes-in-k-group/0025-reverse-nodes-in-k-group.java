/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null ||head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy, pre = dummy, nex = dummy;
        
        int c = 0;cur = head;
        while(cur != null){c++; cur = cur.next;}

        while(c >= k){
            cur = pre.next;
            nex = cur.next;
            for(int i = 1; i < k; i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            c -= k;
        }

        return dummy.next;
    }
}