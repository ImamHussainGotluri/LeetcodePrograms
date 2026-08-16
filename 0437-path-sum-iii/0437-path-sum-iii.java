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
        return everyNode(root, targetSum);
        // Map<Long,Integer> hm=new HashMap<>();
        // hm.put(0L,1);
        // return PathSum(root,targetSum,0L,hm);
    }
    // public int PathSum(TreeNode root,int tar,long currSum,Map<Long,Integer> hm){
    //     if(root==null){
    //         return 0;
    //     }
    //     currSum+=root.val;

    //     int CntPaths=hm.getOrDefault(currSum-tar,0);

    //     hm.put(currSum,hm.getOrDefault(currSum,0)+1);

    //     CntPaths+=PathSum(root.left,tar,currSum,hm);
    //     CntPaths+=PathSum(root.right,tar,currSum,hm);

    //     hm.put(currSum,hm.get(currSum)-1);

    //     return CntPaths;
    // }
    public int everyNode(TreeNode root,int tar){
        if(root==null){
            return 0;
        }

        int totalPaths=everyPath(root,(long)tar);

        totalPaths+=everyNode(root.left,tar);
        totalPaths+=everyNode(root.right,tar);
        return totalPaths;
    }

    public int  everyPath(TreeNode root,long tar){
        if(root==null){
            return 0;
        }

        int cnt=0;
        if(root.val==tar){
            cnt++;
        }

        cnt+=everyPath(root.left,tar-root.val);
        cnt+=everyPath(root.right,tar-root.val);
        return cnt;
    }
}
