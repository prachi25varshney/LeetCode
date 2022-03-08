/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashMap = new HashSet<>();
        while(head!=null){
            if(!hashMap.contains(head))
                hashMap.add(head);
                
            else
                return true;
            head = head.next;
        }
        return false;
    }
}