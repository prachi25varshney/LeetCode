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
    List<Integer> list;
    int max_level =-1;
    public List<Integer> rightSideView(TreeNode root) { 
        this.list  = new ArrayList<>();
        rightSideUtil(root,0);
        return list;
    }
    
    public void rightSideUtil(TreeNode node, int curr_level){
        if(node!=null){
            if(curr_level> max_level){
                 list.add(node.val);
                max_level = curr_level;
            }
            rightSideUtil(node.right,curr_level+1);
            rightSideUtil(node.left,curr_level+1);
        }
    }
}