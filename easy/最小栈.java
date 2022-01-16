class MinStack {//利用辅助栈
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack=new LinkedList<Integer>();
        minStack=new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }
    
    public void pop() {
        xStack.pop();//此举是保证最小值提出后，这里的最小值也一并提出
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
//把这玩意当成是和栈没啥关系的数据结构
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
