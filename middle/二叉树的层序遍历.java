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
class Solution {//广度优先
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<List<Integer>>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){//巧妙地利用队列，每次循环队列存下一层，放出一层后又加入新的一层
            List<Integer> level=new ArrayList<Integer>();
            int currentsize=queue.size();
            for(int i=1;i<=currentsize;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
