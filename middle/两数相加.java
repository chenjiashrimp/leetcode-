/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //这道题我忽略了很多细节上的问题，比如关于ListNode的实例化，一开始要给它null，它不会自己默认为null，有一个构造函数其实什么操作也没有
 //只要是引用类型，都可以用null
 //还有易错的就是，因为没有哨兵结点之类的东西，所以空指针的情况要分开讨论，还有就是指针随时都可能移动，我们最后一般要返回整个链表，所以记得多设一个变量，这些都可以记作套路
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head=null;
       ListNode tail=null;
       int n1=0;
       int n2=0;
       int carry=0;
       while(l1!=null||l2!=null){//l1 l2可能不一样长，被例子给误导了
           n1= l1!=null?l1.val:0;
           n2=l2!=null?l2.val:0;//记住写法
           int sum=n1+n2+carry;
           if(head==null){
               head=tail=new ListNode(sum%10);
           }else{
               tail.next=new ListNode(sum%10);
               tail=tail.next;
           }
           if(l1!=null){
               l1=l1.next;
           }
           if(l2!=null){
               l2=l2.next;
           }
           carry=sum/10;
       }
       if(carry!=0){
           tail.next=new ListNode(carry);//细节，最后一个要进位
       }
       return head;//不能返回tail
    }
}
