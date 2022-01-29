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
class Solution {//注意题目要求，可以不从根结点开始，但是一旦开始了接下来的点就都要选了，否则就不连续了
    public int pathSum(TreeNode root, int targetSum) {//深度优先
        if(root==null){
            return 0;
        }
        int ret=rootSum(root,targetSum);//以root为起点的路线数目
        ret+=pathSum(root.right,targetSum);//不以root为起点
        ret+=pathSum(root.left,targetSum);
        return ret;
    }
    public int rootSum(TreeNode root,int targetSum){
        int ret=0;
        if(root==null){
            return 0;
        }
        int val=root.val;
        if(val==targetSum){
            ret++;
        }
        ret+=rootSum(root.right,targetSum-val);
        ret+=rootSum(root.left,targetSum-val);
        return ret;
    }
}
