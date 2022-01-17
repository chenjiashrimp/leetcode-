class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new LinkedList<String>();
        parenthesis(new StringBuilder(),ans,0,0,n);
        return ans;
    }
    public void parenthesis(StringBuilder str,List<String> ans,int open,int close,int max){//回溯法，暴力法的优化
        if(str.length()==2*max){
            ans.add(str.toString());
            return;
        }
        if(open<max){
            str.append('(');
            parenthesis(str,ans,open+1,close,max);
            str.deleteCharAt(str.length()-1);//回溯的格式
        }
        if(close<open){//顺便连有效性一起确定，比暴力法省时的地方
            str.append(')');
            parenthesis(str,ans,open,close+1,max);
            str.deleteCharAt(str.length()-1);
        }
        return;
    }
}
