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
    List<Integer> ans = new ArrayList();
    int level =-1;
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewUtil(root, 0);
        return ans;
    }
    
    private void rightSideViewUtil(TreeNode root, int currLevel){
        if(root == null)
            return;
        if(currLevel> level){
            level = currLevel;
            ans.add(root.val);
        }
        rightSideViewUtil(root.right, currLevel+1);
        rightSideViewUtil(root.left, currLevel+1);
    }
}