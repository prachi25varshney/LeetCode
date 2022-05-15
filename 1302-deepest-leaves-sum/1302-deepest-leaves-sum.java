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
    HashMap<Integer, List<Integer>> levelList = new HashMap();
    int maxLevel =0;
    public int deepestLeavesSum(TreeNode root) {
        getLevelsList(root,0);
        int deepestLeavesSum =0;
        for(int val : levelList.get(maxLevel)){
            deepestLeavesSum+=val;
        }
        return deepestLeavesSum;
    }
    private void getLevelsList(TreeNode root, int level){
        if(root==null)
            return;
        if(!levelList.containsKey(level))
            levelList.put(level,new ArrayList());
        levelList.get(level).add(root.val);
        maxLevel = Math.max(maxLevel,level);
        getLevelsList(root.left, level+1);
        getLevelsList(root.right,level+1);
        
    }
}