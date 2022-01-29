//一开始超时了，想用深度搜索，用一个bool为形参判断该节点值可不可加
class Solution {//动态规划，每个结点要么选要么不选
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);//做了一个后序遍历，最下面的值先确定了上面的值才能确定
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
      //这个式子巧妙运用了条件，只能有左子树或者右子树
    }
}


class Solution {//打家劫舍Ⅰ，数组线性的更简单
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        int[] f=new int[n];
        int[] g=new int[n];
        f[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            f[i]=g[i+1]+nums[i];
            g[i]=Math.max(g[i+1],f[i+1]);
        }
        return Math.max(f[0],g[0]);
    }
}
