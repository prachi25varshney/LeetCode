/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root, curr;
    int index;
    public BSTIterator(TreeNode root) {
        this.index =-1;
        this.stack = new Stack<>();
        this.root =root;
        this.curr = root;
        
    }
    
    public int next() {
         while(curr!=null){
                stack.push(curr);
                curr = curr.left;
             index++;
            }
            TreeNode temp = stack.pop();
            curr = temp.right;
        index --;
        return temp.val;
    }
    
    public boolean hasNext() {
        return curr!=null||index!=-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */