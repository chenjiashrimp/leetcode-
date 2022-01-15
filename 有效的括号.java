class Solution {
    public boolean isValid(String s) {
         int n=s.length();
        if(n%2==1){//提前判断
            return false;
        }
        Map<Character,Character> pairs=new HashMap<Character,Character>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        Deque<Character> stack=new LinkedList<Character>();//双向队列可以实现栈和队列，官方推荐，不推荐Stack
        for(int i=0;i<n;i++){
            char str=s.charAt(i);//返回索引处的字符
            if(pairs.containsKey(str)){
                if(stack.isEmpty()||stack.peek()!=pairs.get(str)){
                    return false;
                }
                stack.pop();
            }
            else{//else别忘记写，不是所有的都要入栈
                stack.push(str);
            }
        }
        return stack.isEmpty();//注意栈可能非空，偶数但是左右括号数目不是1：1时，考虑周全

    }
}

//补充栈的使用
stack.pop();
stack.push(item);
stack.peek();//返回栈顶但是不会移除

Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};//如何初始化，注意两组括号和分号

  
  
