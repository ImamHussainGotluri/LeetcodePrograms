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
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> arr=new ArrayList<>(); 
        helper(root,arr);
        int sum=0;
        for(int i=0;i<arr.size();i++){
            int val=arr.get(i);
            if(val>=low && val<=high){
                sum+=val;
            }
        }
        return sum;
    }
    public void helper(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        helper(root.left,arr);
        arr.add(root.val);
        helper(root.right,arr);
    }
}