/*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];/*构造长度为0数组*/

    }
}

public class Solution {
    public int[] twoSums(int[] nums,int target){
        Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();//是把值当作key噢，这样才方便搜索
        for(int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i],i)};//顺序
            }
            hashtable.put(nums[i],i);//防止抽到自己，最后在加入
        }
        return new int[0];
    }
}

//hash
//.containsKey()
//.get(key)
//.size()
//迭代 .keySet() .values()
//for(:.keySet())
//.clear()清除所有
//.remove(key)移除

//数据类型 抽象数据类型 数据结构 没有抽象数据结构！！！
//逻辑结构 数据与数据间关系的集合 存储结构实现逻辑结构
//所以hash（散列）是属于存储结构的，负责实现；栈那些是逻辑结构

//哈希冲突 哈希函数 这些都是内部原理，做算法题无需考虑这些七七八八的，当成工具拿来用就行了
//哈希冲突针对的是不同key映射到同一个地址上，而key相同的那叫覆盖和冲突没有任何关系，如果hash值同key同，会覆盖，hash值同key不同会加在链表

//Entry是数组的元素 Entry含有key-value对和指向下个元素的引用，构成链表，Entry其实就是链表的一环
