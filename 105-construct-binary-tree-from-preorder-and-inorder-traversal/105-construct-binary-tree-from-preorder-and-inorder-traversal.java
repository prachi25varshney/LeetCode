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
    int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildBT(0,inorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildBT(int sin,int ein,int spre,int epre){
        if(sin>ein)
            return null;
        TreeNode newNode = new TreeNode(preorder[spre]);
        if(spre==epre)
            return newNode;
        int index = searchInorderIndex(sin,ein,newNode.val);
        newNode.left = buildBT(sin,index-1,spre+1,epre-ein+index);
        newNode.right = buildBT(index+1,ein,spre-sin+index+1,epre);
        return newNode;
    }
    public int searchInorderIndex(int start, int end, int val){
        int i;
        for(i=start;i<=end;i++){
            if(inorder[i]==val)
                break;
        }
        return i;
    }
}