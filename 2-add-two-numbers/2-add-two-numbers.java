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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head = null;
        ListNode curr = null;
        while(l1!=null || l2!=null){
            ListNode sum = new ListNode(0); 
            sum.val = (l1!=null?l1.val:0)+ (l2!=null?l2.val:0) + carry;
            if(sum.val>=10){
                carry=1;
                sum.val=sum.val-10;
            }
            else
                carry=0;
            if(head==null){
                head = sum;
                curr = head;
            }else{
                curr.next= sum;
                curr = curr.next;
            }
            if(l1!=null)
                l1= l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            curr.next=node;
        }
       return  head;
    }
}