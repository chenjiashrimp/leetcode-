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
class Solution {//之前做过的题目了，还是用递归
    private Map<Integer,Integer> indexMap;
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){//边界条件要注意
            return null;
        }
        int preorder_root=preorder_left;
        int inorder_root=indexMap.get(preorder[preorder_root]);
        TreeNode root=new TreeNode(preorder[preorder_root]);
        int leftSubTreeSize=inorder_root-inorder_left;
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+leftSubTreeSize,inorder_left,inorder_root-1);
        root.right=myBuildTree(preorder,inorder,preorder_left+leftSubTreeSize+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap=new HashMap<Integer,Integer>();
        for(int i=0;i<preorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int n=preorder.length;
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
}
