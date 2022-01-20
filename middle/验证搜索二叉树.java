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
class Solution {//一开始错误是因为理解错误题意，要求的是左边所有点都要小，而不仅仅是左子树的根结点，所以比较时既要比上限也要比下限，因此需要多设变量表示上下限
    public boolean isValidBST(TreeNode root) {
       return search(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean search(TreeNode root,long lower,long upper){//注意数据范围
        if(root==null){
            return true;
        }
        if(root.val<=lower||root.val>=upper){//先把大小比了，我自己写的代码把这里和下面合起来写，然后就不知道该怎么写了
          //把比大小写在后面，然后就不知道lower和upper要怎么更新了
            return false;
        }//要有整体的思维，先不要带入实例去思考，明确变量的定义，然后根据定义写式子
        return search(root.left,lower,root.val)&&search(root.right,root.val,upper);//不需要比较lower upper val大小关系了，前面比过了
    }
}
