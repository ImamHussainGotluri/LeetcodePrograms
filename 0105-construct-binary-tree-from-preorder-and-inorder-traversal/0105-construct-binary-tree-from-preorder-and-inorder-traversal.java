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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> hm=new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return helper(preorder,0,n-1,inorder,0,n-1,hm);
    }
    public TreeNode helper(int preorder[],int preSt,int preEnd,int inorder[],int inSt,int inEnd,Map<Integer,Integer> hm){
        if(preSt>preEnd || inSt>inEnd){
            return null;
        }

        TreeNode root=new TreeNode(preorder[preSt]);

        int inroot=hm.get(root.val);
        int numLeft=inroot-inSt;

        root.left=helper(preorder,preSt+1,preSt+numLeft,inorder,inSt,inroot-1,hm);
        root.right=helper(preorder,preSt+numLeft+1,preEnd,inorder,inroot+1,inEnd,hm);

        return root;
    }
}