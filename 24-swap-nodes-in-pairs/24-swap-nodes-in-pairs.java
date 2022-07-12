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
        
        ListNode curr = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        prev.next = curr;
        while(curr!=null && curr.next!=null){
            ListNode next = curr.next;
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
            curr =  curr.next;
        }
        return dummyNode.next;
    }
}