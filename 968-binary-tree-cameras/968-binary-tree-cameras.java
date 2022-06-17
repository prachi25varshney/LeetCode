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
    int count =0;
    public int minCameraCover(TreeNode root) {
        if(root==null)
            return 0;
        int camera = dfs(root);
        if(camera==-1)
            count++;
        return count;
    }
    public int dfs(TreeNode root){
        if(root.left == null && root.right ==null)
            return -1;
        int left =0, right =0;
        if(root.left!=null)
            left = dfs(root.left);
        if(root.right!=null)
            right =dfs(root.right);
        if(left==-1 || right==-1){
            count++;
            return 1;
        }
        else if(left ==0 && right ==0)
            return -1;
        else
            return 0;
    }
}