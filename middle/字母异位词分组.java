class Solution {//思路还是挺好想的，用map，这题主要是涉及很多method 还有各种写法，要注意
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashtable=new HashMap<String,List<String>>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);//所以转化的目的仅仅是为了排序，方便通过key直接找出同类字符串
            String key=new String(array);//又把类型转化回来了
            List<String> list=hashtable.getOrDefault(key,new ArrayList<String>());//这个method记住了，找不到key返回自己设置的值
            list.add(str);
            hashtable.put(key,list);//会覆盖
        }
        return new ArrayList<List<String>>(hashtable.values());//不能直接返回values注意题目让我们返回的类型
    }
}
