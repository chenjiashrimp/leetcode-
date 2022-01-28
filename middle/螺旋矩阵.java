class Solution {//一层一层遍历就可以了，要注意边界问题，角上元素不要重复计入
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        List<Integer> order=new ArrayList<Integer>();
        if(matrix==null||m==0||n==0){
            return order;
        }
        int left=0,right=n-1,top=0,bottom=m-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++){
                order.add(matrix[top][i]);//注意是行变化还是列变化
            }
            for(int i=top+1;i<=bottom;i++){
                order.add(matrix[i][right]);
            }
            if(left<right&&top<bottom){//需要再判断一次，否则会重复计数
                for(int i=right-1;i>left;i--){
                    order.add(matrix[bottom][i]);
                }
                for(int i=bottom;i>top;i--){
                    order.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
