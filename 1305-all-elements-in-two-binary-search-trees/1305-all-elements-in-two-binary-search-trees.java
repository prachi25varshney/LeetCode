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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        traverseTree(root1);
        traverseTree(root2);
        List<Integer> allElements = new ArrayList<>();
        while(!pq.isEmpty()){
            allElements.add(pq.poll());
        }
        return allElements;
    }
    public void traverseTree(TreeNode root){
        if(root==null)
            return;
        pq.add(root.val);
        traverseTree(root.left);
        traverseTree(root.right);
    }
}