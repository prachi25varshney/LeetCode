/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> q = new LinkedList<>();
        if(root.left!=null)
            q.add(root.left);
        if(root.right!=null)
            q.add(root.right);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1;i<=size;i++){
                if(i==size){
                    Node temp = q.remove();
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
                else{
                    Node temp = q.peek();
                    q.remove().next = q.peek();
                     if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
            }
        }
        return root;
    }
}