class Solution {//从高到低来看
    public int[][] reconstructQueue(int[][] people) {
       Arrays.sort(people,new Comparator<int[]>(){
           public int compare(int[] person1,int[] person2){
               if(person1[0]!=person2[0]){
                   return person2[0]-person1[0];//注意谁减谁，身高从高到低，人数从少到多
               }else{
                   return person1[1]-person2[1];
               }
           }
       });
       List<int[]> ans=new ArrayList<int[]>();
       for(int[] person:people){//身高从高到低排，安排顺序也是高的先来，所以先放的影响后放的，后放的不影响先放的
           ans.add(person[1],person);//add可以加在制定位置，第一个相当于是index
       }
       return ans.toArray(new int[ans.size()][]);
    }
}
