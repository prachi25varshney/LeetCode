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
        
        int lengthA=0, lengthB =0;
        ListNode currA = headA, currB = headB;
        
        while(currA!=null){
            lengthA++;
            currA= currA.next;
        }
        
        while(currB!=null){   // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
            lengthB++;
            currB= currB.next;
        }
        
        currA = headA; currB =headB;
        
        int skipNodes = Math.abs(lengthA - lengthB);
        
        if(lengthA>lengthB){
            while(skipNodes-- >0){
                currA = currA.next;
            }
        }
        else if(lengthA<lengthB){
            while(skipNodes-- >0){
                currB = currB.next;
            }
        }
        
        while(currA!=null && currB!=null){
            if(currA==currB)
                return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}