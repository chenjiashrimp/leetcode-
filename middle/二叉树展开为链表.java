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
class Solution {//注意题目要求，要在原来的二叉树上做改变，不是新创建一个链表，而是得到一个像链表的二叉树
  //指针的指向要改变，关键在于怎么改，改变顺序，这里使用前序遍历
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<TreeNode>();
        preorder(root,list);
        int size=list.size();
        for(int i=1;i<size;i++){
            TreeNode pre=list.get(i-1);
            TreeNode cur=list.get(i);
            pre.left=null;
            pre.right=cur;//需要看出这个变化的规律
        }
    }
    public void preorder(TreeNode root,List<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        preorder(root.left,list);
        preorder(root.right,list);
    }
}
