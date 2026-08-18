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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int l=0;
            int r=0;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.peek().node;
                int idx=q.peek().idx;
                q.poll();
                if(i==0){
                    l=idx;
                }
                if(i==size-1){
                    r=idx;
                }

                if(curr.left!=null){
                    q.add(new Pair(curr.left,2*idx+1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,2*idx+2));
                }
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}