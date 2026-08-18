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
    public int countNodes(TreeNode root) {
       return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight=lefthightGet(root);
        int rightHeight=righthightGet(root);

        if(leftHeight==rightHeight){
            return (int)Math.pow(2,leftHeight)-1;
        }

        return 1+helper(root.left)+helper(root.right);
    }
    public int lefthightGet(TreeNode node){
        int height=0;
        while(node!=null){
            height++;
            node=node.left;
        }
        return height;
    }
    public int righthightGet(TreeNode node){
        int height=0;
        while(node!=null){
            height++;
            node=node.right;
        }
        return height;
    }
}