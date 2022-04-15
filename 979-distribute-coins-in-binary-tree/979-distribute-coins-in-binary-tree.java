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
    int ans =0;
    public int distributeCoins(TreeNode root) {
        getMinMoves(root);
        return ans;
    }
    private int getMinMoves(TreeNode root){
        if(root == null)
            return 0;
        int left = getMinMoves(root.left);
        int right = getMinMoves(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right -1;
    }
}