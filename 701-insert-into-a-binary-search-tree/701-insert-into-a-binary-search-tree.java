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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode node = root, prev = null;
        while(node!=null){
            prev = node;
            if(node.val<val)
                node = node.right;
            else if(node.val>val)
                node = node.left;
        }
        node = new TreeNode(val);
        if(prev.val>val)
            prev.left = node;
        else
            prev.right = node;
        return root;
    }
}