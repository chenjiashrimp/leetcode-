class Solution {//核心思想就是搞一个队列存数据，并且这些数据按大小拍好，时时更新
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2){return nums;}//特殊情况
        LinkedList<Integer> queue=new LinkedList<Integer>();//这里用Link不行，难不成是用到了一些method的原因？
        int[] results=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){//顶端是最大元素的下标，队列从到到尾降序
                queue.pollLast();//取出最后一个数（队尾）
            }
            queue.addLast(i);//加在最后面
            if(queue.peek()<i-k+1){//不在窗口里要提取出来
                queue.poll();
            }
            if(i>=k-1){
                results[i-k+1]=nums[queue.peek()];
            }
        }
        return results;
    }
}
