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
    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
      //最大直径未必穿过根，maxd其实就是要比较各个结点的直径然后选出一个最大的
        return Math.max(Left,Right)+1;//返回节点深度
    }
}
