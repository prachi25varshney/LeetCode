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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA!=null){
            hashSet.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(hashSet.contains(headB)){
                return headB;
            }
            headB= headB.next;
        }
        return null;
    }
}