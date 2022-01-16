class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode p,TreeNode q){//跳出思维定势，一定要有数据结构带有的method遍历吗
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){//注意两个if的顺序
            return false;
        }
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
