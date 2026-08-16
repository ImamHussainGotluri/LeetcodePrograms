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
    public int pathSum(TreeNode root, int targetSum) {
        // return everyNode(root, targetSum);
        Map<Long,Integer> hm=new HashMap<>();
        hm.put(0L,1);
        return PathSum(root,targetSum,0L,hm);
    }
    public int PathSum(TreeNode root,int tar,long sum,Map<Long,Integer> hm){
        if(root==null){
            return 0;
        }

        sum+=root.val;

        int totalPaths=hm.getOrDefault(sum-tar,0);

        hm.put(sum,hm.getOrDefault(sum,0)+1);

        totalPaths+=PathSum(root.left,tar,sum,hm);
        totalPaths+=PathSum(root.right,tar,sum,hm);

        hm.put(sum,hm.get(sum)-1);

        return totalPaths;
    }

    // public int everyNode(TreeNode root,int tar){
    //     if(root==null){
    //         return 0;
    //     }

    //     int totalPaths=everyPath(root,(long)tar);

    //     totalPaths+=everyNode(root.left,tar);
    //     totalPaths+=everyNode(root.right,tar);
    //     return totalPaths;
    // }

    // public int  everyPath(TreeNode root,long tar){
    //     if(root==null){
    //         return 0;
    //     }

    //     int cnt=0;
    //     if(root.val==tar){
    //         cnt++;
    //     }

    //     cnt+=everyPath(root.left,tar-root.val);
    //     cnt+=everyPath(root.right,tar-root.val);
    //     return cnt;
    // }
}
