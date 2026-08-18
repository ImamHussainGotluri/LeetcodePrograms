/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }

        // List<List<TreeNode>> res=new ArrayList<>();
        // Paths(root,p,q,res,new ArrayList<>());
        // List<TreeNode> arr1=res.get(0);
        // List<TreeNode> arr2=res.get(1);
        // for(int i=0;i<Math.min(arr1.size(),arr2.size());i++){
        //     if(arr1.get(i).val!=arr2.get(i).val){
        //         return arr1.get(i-1);
        //     }
        // }
        // return arr2.get(Math.min(arr1.size(),arr2.size())-1);
    }
    // public void Paths(TreeNode root,TreeNode p,TreeNode q,List<List<TreeNode>> res,List<TreeNode> ans){
    //     if(root==null){
    //         return;
    //     }
    //     ans.add(root);
    //     if(root==p || root==q){
    //         res.add(new ArrayList<>(ans));
    //     }
    //     Paths(root.left,p,q,res,ans);
    //     Paths(root.right,p,q,res,ans);
    //     ans.remove(ans.size()-1);
    // }
}