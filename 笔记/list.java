//List LinkedList ArrayList
//.length() .add
//.get()
//.equals()

//ArrayList
//toArray(new int[]) toArray(new int[][]) 数组没有名字，或者先构造一个有名字的数组也可以
//new ArrayList<>(map.values())

//Collections.swap(List<>,i,j);交换

//以下情况使用 ArrayList :
//频繁访问列表中的某一个元素。
//只需要在列表末尾进行添加和删除元素操作。

//以下情况使用 LinkedList :
//你需要通过循环迭代来访问列表中的某些元素。
//需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。

//LinkedList 继承了 AbstractSequentialList 类。
//LinkedList 实现了 Queue 接口，可作为队列使用。
//LinkedList 实现了 List 接口，可进行列表的相关操作。
//LinkedList 实现了 Deque 接口，可作为队列使用。
//LinkedList 实现了 Cloneable 接口，可实现克隆。
//LinkedList 实现了 java.io.Serializable 接口，即可支持序列化，能通过序列化去传输。

//.add默认加在最后 .addFirst .addLast .removeFirst .removeLast .getFirst .getLast
//.peek() .poll() 默认返回第一个元素
