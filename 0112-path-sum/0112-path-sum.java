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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null){
         return false;
       }

       if(root.left==null && root.right==null){
        return targetSum==root.val;
       }

       boolean left=hasPathSum(root.left,targetSum-root.val);
       boolean right=hasPathSum(root.right,targetSum-root.val);

       return left || right;
    }
    // boolean res=false;
    // public void PathSum(int tar,int sum,TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     if(root.left==null && root.right==null){
    //         sum+=root.val;
    //         if(sum==tar){
    //             res=true;
    //         }
    //         return;
    //     }
    //     PathSum(tar,sum+root.val,root.left);
    //     PathSum(tar,sum+root.val,root.right);
    // }
}