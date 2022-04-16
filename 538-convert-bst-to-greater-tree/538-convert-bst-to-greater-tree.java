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
    public TreeNode convertBST(TreeNode root) {
        int count =0;
        convertBST(root,0);
        return root;
    }
    int convertBST(TreeNode root, int count){
        if(root == null)
            return count;
        int right = convertBST(root.right,count);
        root.val = root.val + right;
        return convertBST(root.left,root.val);
    }
}