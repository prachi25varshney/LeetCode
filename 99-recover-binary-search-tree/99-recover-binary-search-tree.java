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
class Solution {
    TreeNode prev = null, firstNode = null, secondNode = null;
    public void recoverTree(TreeNode root) {
        recoverBSTUtil(root);
        if(firstNode!=null && secondNode!=null){
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }
    public void recoverBSTUtil(TreeNode root){
        if(root==null)
            return;
        recoverBSTUtil(root.left);
        if(prev!=null && prev.val>root.val){
            if(firstNode==null)
                firstNode=prev;
            secondNode = root;
        }
        prev = root;
        recoverBSTUtil(root.right);
    }
}