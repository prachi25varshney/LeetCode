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
    int sum =0;
    public int sumRootToLeaf(TreeNode root) {
        if(root.left==null && root.right==null)
            return root.val;
        sumrootToLeafUtil(root, new ArrayList<>());
        return sum;   
    }
    public void sumrootToLeafUtil(TreeNode root, List<Integer> temp){
        if(root.left==null && root.right==null){
            temp.add(root.val);
            sum+= convertBinaryToDecimal(temp);
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);  
        if(root.left!=null){
            sumrootToLeafUtil(root.left,temp);
        }
        if(root.right!=null){
            sumrootToLeafUtil(root.right,temp);
        }
        temp.remove(temp.size()-1);
    }
    private int convertBinaryToDecimal(List<Integer> arr){
        int decimal=0,base=1;
        for(int i= arr.size()-1 ;i>=0;i--){
            if(arr.get(i)==1)
                decimal+=base;
            base = base*2;
        }
        return decimal;
    }
}