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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        sumRootToLeafUtil(root, 0);
        return sum;
    }
    public void sumRootToLeafUtil(TreeNode root, int num){
        if(root == null) return ;
        num = num*2 + root.val;
        
        if(root.left == null && root.right == null){
            sum += num;
            return ;
        }
        if(root.left != null){
            sumRootToLeafUtil(root.left, num);
        }
        if(root.right != null){
            sumRootToLeafUtil(root.right, num);
        }
    }
}