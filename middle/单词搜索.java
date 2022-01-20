class Solution {//回溯模板，记住
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean flag=search(board,visited,word,i,j,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,boolean[][] visited,String word,int i,int j,int index){
        if(board[i][j]!=word.charAt(index)){
            return false;
        }else if(index==word.length()-1){
            return true;
        }
        boolean result=false;
        visited[i][j]=true;
        int[][] direction=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int k=0;k<4;k++){
            int nexti=i+direction[k][0];
            int nextj=j+direction[k][1];
            if(0<=nexti&&nexti<board.length&&0<=nextj&&nextj<board[0].length){
                if(visited[nexti][nextj]==false){
                    boolean flag=search(board,visited,word,nexti,nextj,index+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=false;
        return result;
    }
}
