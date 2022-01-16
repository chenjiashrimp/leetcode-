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

class Solution {//使用迭代
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode u,TreeNode v){
        Queue<TreeNode> p=new LinkedList<TreeNode>();
        p.offer(u);
        p.offer(v);
        while(!p.isEmpty()){
            TreeNode u1=p.poll();
            TreeNode v1=p.poll();
            if(u1==null&&v1==null){
                continue;//不能return true 因为未必遍历完
            }
            if(u1==null||v1==null||u1.val!=v1.val){
                return false;
            }
            p.offer(u1.left);
            p.offer(v1.right);
            p.offer(u1.right);
            p.offer(v1.left);
        }
        return true;
    }
}

//补充 java队列
//Queue
//添加元素add() offer()超出容量会返回false，而add会异常
//删除 remove() poll()同上
//获取队头元素 element() peek()没有的话peek会返回null
