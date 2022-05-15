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
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        int length = depthOfTree(root);
        return deepestLeaf(root,length);
    }

    public int depthOfTree(TreeNode node){
        if(node==null)
            return 0;
        if(node.left== null && node.right==null)
            return 1;
        return 1 + Math.max(depthOfTree(node.left),depthOfTree(node.right));
    }
    public int deepestLeaf(TreeNode node,int length){
        if(node==null)
            return 0;
        if(length==1)
            sum = sum + node.val;
        if(node.left!=null)
            deepestLeaf(node.left,length-1);
        if(node.right!=null)
            deepestLeaf(node.right,length-1);
        return sum;
    }
}