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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> hm=new HashMap<>();
        Set<Integer> hs=new HashSet<>();
        TreeNode root=new TreeNode(-1);
        TreeNode parent;
        TreeNode child;
        for(int arr[]:descriptions){
            int p=arr[0];
            int c=arr[1];
            int isLeft=arr[2];

            hm.putIfAbsent(p,new TreeNode(p));
            hm.putIfAbsent(c,new TreeNode(c));

            parent=hm.get(p);
            child=hm.get(c);

            if(isLeft==1){
                parent.left=child;
            }
            else{
                parent.right=child;
            }

            hs.add(c);
        }

        for(int node:hm.keySet()){
            if(!hs.contains(node)){
                return hm.get(node);
            }
        }
        return null;
    }
}