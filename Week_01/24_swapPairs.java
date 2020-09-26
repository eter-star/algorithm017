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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prevNode = dummy;
        ListNode firstNode = null;
        ListNode secondNode = null;
        while(head!=null && head.next !=null){
            firstNode = head;
            secondNode = head.next;
            
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode = firstNode;
            
            head = firstNode.next;
        }
        
        return dummy.next;
        
    }
}