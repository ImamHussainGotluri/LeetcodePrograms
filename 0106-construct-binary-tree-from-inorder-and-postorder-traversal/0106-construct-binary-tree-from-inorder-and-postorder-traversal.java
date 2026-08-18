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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer,Integer> inmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }
        return buildtree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inmap); 
    }
    public TreeNode buildtree(int[] postorder,int postSt,int postEnd,int[] inorder,int inSt,int inEnd,Map<Integer,Integer> inmap){
       if(postSt>postEnd || inSt>inEnd){
            return null; 
       }

       TreeNode root=new TreeNode(postorder[postEnd]);

       int inroot=inmap.get(root.val);
       int numLeft=inroot-inSt;

       root.left=buildtree(postorder,postSt,postSt+numLeft-1,inorder,inSt,inroot-1,inmap);
       root.right=buildtree(postorder,postSt+numLeft,postEnd-1,inorder,inroot+1,inEnd,inmap);

       return root;
    }
}