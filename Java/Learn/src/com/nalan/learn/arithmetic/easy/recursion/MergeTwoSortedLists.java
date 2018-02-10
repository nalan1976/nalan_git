package com.nalan.learn.arithmetic.easy.recursion;
/**
 * 问题：
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * 从这个例子中学到：
 * 1）递归的写法：
 *      a）退出条件要写在一开始；
 *      b）将复杂的问题转化为多次调用自己的简单问题；
 *      c）结果：函数的所有数据的改变要从满足退出条件开始，前面都是做准备；
 * 2）题目中没有给出单向列表的常用方法实现，这表明根本就用不着这些方法，此时应该考虑用递归等非常规方法
 * 3）链表：
 *      a）给链表排序就是让其next指向下一个正确的节点，仅此而已
 * 4）非静态代码块：在创建类实例的时候被执行，执行顺序早于构造函数，晚于静态块，可定义多个块
 */

public class MergeTwoSortedLists {
    static ListNode lst1[] = new ListNode[3] ;
    static ListNode lst2[] = new ListNode[3] ;
    public MergeTwoSortedLists(){
        System.out.print("constructor beginning\n");
    }
    //使用非静态代码块，在创建类实例的时候被执行，效果与构造函数相同
    /*public MergeTwoSortedLists()*/
    {
        System.out.print("non-static block beginning\n");
        lst1[0] = new ListNode(1);
        lst1[1] = new ListNode(2);
        lst1[2] = new ListNode(4);
        lst1[0].next = lst1[1];
        lst1[1].next = lst1[2];
        lst1[2].next = null;
    }
    {
        lst2[0] = new ListNode(1) ;
        lst2[1] = new ListNode(3) ;
        lst2[2] = new ListNode(4) ;
        lst2[0].next = lst2[1];
        lst2[1].next = lst2[2];
        lst2[2].next = null;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //刚开始这里写成了l1.next和l2.next，怎么都不对
        if ( l1 == null )
            return l2;
        if ( l2 == null )
            return l1;

        //比较2个节点当前值：
        // 1）选小的那个作为当前节点
        // 2）当前节点的next指向，next和大的节点中小的那个，所以可以递归调用自身
        // 3）返回当前节点
        ListNode mergeHead;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }


    public static void main(String args[]) {
        {
            System.out.print("normal block\n");
        }
        System.out.print("main beginning\n");
        MergeTwoSortedLists test = new MergeTwoSortedLists();

        mergeTwoLists(lst1[0], lst2[0]);
        //将2个链表都打出来，以验证排序结果是否正确
        ListNode result = lst1[0];
        for( int i = 0; result != null; i++){
            System.out.print(result.val);
            result = result.next;
        }

        System.out.print("\n");
        result = lst2[0];
        for(int i = 0; result != null; i++){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.print("\n");
    }
}
