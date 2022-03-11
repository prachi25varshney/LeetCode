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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null)
            return head;
        ListNode curr = head, prev = null;
        int length=0;
        while(curr!=null){
            length++;
            prev = curr;
            curr = curr.next;
        }
        int rotateTimes = k % length;
        if(rotateTimes == 0)
            return head;
        int index=1;
        curr = head;
        rotateTimes = length - rotateTimes;
        while(index!= rotateTimes){
            curr = curr.next;
            index++;
        }
        ListNode middle = curr.next;
        curr.next = null;
        
        prev.next = head;
        head = middle;
        
        return head;
    }
}