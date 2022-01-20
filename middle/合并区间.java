class Solution {//这题方法挺笨，但是一些写法要注意
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals,new Comparator<int[]>(){//这个是比较器，自己写，用来给数组排序，注意格式
            public int compare(int[] interval1,int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        List<int[]> merged=new ArrayList<int[]>();
        for(int i=0;i<intervals.length;i++){
            int L=intervals[i][0],R=intervals[i][1];
            if(i==0||merged.get(merged.size()-1)[1]<L){//if条件
                merged.add(new int[]{L,R});
            }else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],R);//考虑细节了，可能存在一个数组包着另一个数组的情况，所以还要比较一次大小
            }
        }
        return merged.toArray(new int[merged.size()][]);//一定要注意数据类型，尤其是引用类型转化为基本类型
    }
}
