class Solution {//回溯+剪枝
    private List<String> ans=new ArrayList<String>();
    public List<String> removeInvalidParentheses(String s) {//题目要求最少，所以首先要找出需要删除的最小数，根据左右括号两两配对
        int lremove=0,rremove=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                lremove++;
            }else if(s.charAt(i)==')'){//不要直接else因为输入字符不只有左右括号
                if(lremove==0){
                    rremove++;
                }else{
                    lremove--;
                }
            }
        }
        helper(s,0,lremove,rremove);
        return ans;
    }
    public void helper(String str,int start,int lremove,int rremove){
        if(lremove==0&&rremove==0){
            if(isValid(str)){//注意判断
                ans.add(str);
            }
            return;
        }
        for(int i=start;i<str.length();i++){//注意是从start开始删除要有顺序地从头开始
            if(i!=start&&str.charAt(i)==str.charAt(i-1)){//剪枝，如果连续几个字符是一样的括号那么删除哪个其实一样
                continue;
            }
            if(lremove+rremove>str.length()-i){//剪枝
                return;
            }
            if(lremove>0&&str.charAt(i)=='('){
                helper(str.substring(0,i)+str.substring(i+1),i,lremove-1,rremove);
            }
            if(rremove>0&&str.charAt(i)==')'){
                helper(str.substring(0,i)+str.substring(i+1),i,lremove,rremove-1);//如何得到子串
            }
        }
    }
    public boolean isValid(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                cnt++;
            }else if(str.charAt(i)==')'){
                cnt--;
                if(cnt<0){
                    return false;
                }
            }
        }
        return cnt==0;
    }
}
