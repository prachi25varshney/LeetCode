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
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList();
        if(root==null)
            return list;
        HashSet<Integer> hs = new HashSet();
        for(int i : to_delete)
            hs.add(i);
        
        root = delNodesUtil(root, hs, list);
        if(root!=null) list.add(0,root);
        return list;
    }
    private TreeNode delNodesUtil(TreeNode root, HashSet<Integer> hs, List<TreeNode> list){
        
        if(root!=null){
            root.left = delNodesUtil(root.left, hs, list);
            root.right = delNodesUtil(root.right, hs, list);
            if(hs.contains(root.val)){
                if(root.left!=null) list.add(root.left);
                if(root.right!=null) list.add(root.right);
                return null;
            }
            return root;
        }
        return null;
    }
}