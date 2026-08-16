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
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        PathSum(root);
        return max;
    }
    int max=Integer.MIN_VALUE;
    public int PathSum(TreeNode root){
       if(root==null){
            return 0;
       }

       int left=PathSum(root.left);
       int right=PathSum(root.right);

       left=Math.max(0,left);
       right=Math.max(0,right);

       max=Math.max(max,root.val+left+right);

       return root.val+Math.max(left,right);
    } 
}