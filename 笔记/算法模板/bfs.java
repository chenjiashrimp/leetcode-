class Solution {
    int count=1;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        visited[0][0]=true;
        bfs(m,n,k,0,0,visited);
        return count;
    }
    public void bfs(int m,int n,int max,int i,int j,boolean[][] visited){
        int[][] direction=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int k=0;k<4;k++){
            int nexti=i+direction[k][0];
            int nextj=j+direction[k][1];
            if(0<=nexti&&nexti<m&&0<=nextj&&nextj<n&&!visited[nexti][nextj]){
                if(nexti/10+nexti%10+nextj/10+nextj%10<=max){
                    visited[nexti][nextj]=true;
                    count++;
                    bfs(m,n,max,nexti,nextj,visited);
                }
            }
        }
    }
}
