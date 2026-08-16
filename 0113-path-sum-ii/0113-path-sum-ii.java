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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        helper(targetSum,root,res,new ArrayList<>());
        return res;
    }
    public void helper(int tar,TreeNode root,List<List<Integer>> res,List<Integer> ans){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            if(tar==root.val){
                ans.add(root.val);
                res.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
            }
        }

        ans.add(root.val);
        helper(tar-root.val,root.left,res,ans);
        helper(tar-root.val,root.right,res,ans);

        ans.remove(ans.size()-1);
    }
}