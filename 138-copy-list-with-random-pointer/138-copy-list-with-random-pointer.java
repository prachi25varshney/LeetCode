/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node curr = head;
        Node temp =null;
        while(curr!=null){
            temp = new Node(curr.val);
            temp.next= curr.next;
            curr.next = temp;
//temp.random= (curr.random!=null?curr.random.next:curr.random);
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.next!=null){
                curr.next.random = (curr.random!=null?curr.random.next:curr.random);
            }
            curr =(curr.next!=null?curr.next.next:curr.next);
        }
        curr = head; 
        Node copy = head.next;
        temp =copy;
        while(curr!=null && copy!=null){
            curr.next= curr.next!=null?curr.next.next:curr.next;
            copy.next = copy.next!=null?copy.next.next:copy.next;
            curr = curr.next;
            copy= copy.next;
        }
        //copy =temp; curr= head;
        
        return temp;
    }
}