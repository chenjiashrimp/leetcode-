class Solution {//递归搞定
    public List<List<Integer>> subsets(int[] nums) {
        return findsets(nums,nums.length-1);
    }
    public List<List<Integer>> findsets(int[] nums,int index){
        if(index==0){//这里不知道怎么简化，能不能不设那么多变量，直接一步到位
            //编译错了好多次，要记住什么时候写List，什么时候ArrayList
            List<List<Integer>> set=new ArrayList<List<Integer>>();
            set.add(new ArrayList<Integer>());
            List<Integer> list=new ArrayList<Integer>();
            list.add(nums[0]);
            set.add(list);
            return new ArrayList<List<Integer>>(set);//括号里的玩意得是同一类型
}
        List<List<Integer>> sets=findsets(nums,index-1);
        int size=sets.size();
        for(int i=0;i<size;i++){
            List<Integer> list=new ArrayList<Integer>(sets.get(i));
            list.add(nums[index]);
            sets.add(list);
        }
        return sets;
    }
}
//ArrayList的构造函数总共有三个：

//（1）ArrayList()构造一个初始容量为 10 的空列表。
List<String> list1 = new ArrayList<>();
//（2）ArrayList(int initialCapacity)构造一个具有指定初始容量的空列表。
List<String> list2 = new ArrayList<>(6);
//（3）ArrayList(Collection<? extends E> c)构造一个包含指定 collection 的元素的列表，这些元素是按照该 collection 的迭代器返回它们的顺序排列的。
List<String> list3 = new ArrayList<>(list2);
