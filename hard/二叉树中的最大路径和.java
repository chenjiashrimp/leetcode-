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
class Solution {//递归，把路径的每一个节点当作根结点
    int maxValue=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxValue;
    }
    public int maxGain(TreeNode root){//明确子问题，以根结点为起点的路径最大值
        if(root==null){
            return 0;
        }
        int left=Math.max(maxGain(root.left),0);//类似后序遍历先算下面再算上面
        int right=Math.max(maxGain(root.right),0);
        int maxPath=root.val+left+right;
        maxValue=Math.max(maxValue,maxPath);
        return root.val+Math.max(left,right);//得到最大贡献值
    }
}
