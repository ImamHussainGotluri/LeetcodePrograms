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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],i);
        }
        return helper(nums,0,n-1,n);
    }
    public TreeNode helper(int nums[],int l,int r,int n){
        if(l>r){
            return null;
        }

        int mid=maxFun(nums,l,r);
        TreeNode root=new TreeNode(nums[mid]);

        root.left=helper(nums,l,mid-1,n);
        root.right=helper(nums,mid+1,r,n);

        return root;
    }
    public int maxFun(int nums[],int l,int r){
        int max=l;
        for(int i=l+1;i<=r;i++){
            if(nums[i]>nums[max]){
                max=i;
            }   
        }
        return max;
    }
}