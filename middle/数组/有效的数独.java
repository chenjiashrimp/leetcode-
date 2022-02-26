class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[][] line=new boolean[9][10];
       boolean[][] row=new boolean[9][10];
       boolean[][] matrix=new boolean[9][10];
       for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
               int number=board[i][j]-'0';
               int x=(i/3)*3+j/3;
               if(number>0){
                   if(line[i][number]||row[j][number]||matrix[x][number]){
                       return false;
                   }else{
                       line[i][number]=true;
                       row[j][number]=true;
                       matrix[x][number]=true;
                   }
               }
           }
       }
       return true;
    }
    public boolean isNumber(char number){
        if(number-'0'>0){
            return true;
        }else{
            return false;
        }
    }
}
