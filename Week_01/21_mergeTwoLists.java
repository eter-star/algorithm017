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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = null;
        if(l1.val < l2.val){
            head = new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        }
        else{
            head = new ListNode(l2.val, mergeTwoLists(l1, l2.next));
        }
        
        return head;
    }
}