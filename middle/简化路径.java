class Solution {//使用栈进行处理
    public String simplifyPath(String path) {
        String[] names=path.split("/");
        Deque<String> stack=new ArrayDeque<String>();
        for(String name:names){
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(name.length()>0&&!".".equals(name)){
                stack.offerLast(name);
            }
        }
        StringBuffer ans=new StringBuffer();
        if(stack.isEmpty()){
            ans.append("/");
        }else{
            while(!stack.isEmpty()){
                ans.append("/");
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
//StringBuffer and StringBuilder
//都是能够修改的字符串，而且不产生新的未使用对象
//在使用 StringBuffer 类时，每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象，所以如果需要对字符串进行修改推荐使用 StringBuffer。
//StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
//由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
