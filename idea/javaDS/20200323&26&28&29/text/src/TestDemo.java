import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-23
 * Time: 17:00
 */

public class TestDemo {

    public static void main(String[] args) {
        com.bit.src1.TestDemo demo = new com.bit.src1.TestDemo();

        //System.out.println(demo.value);

    }


    /**
     * 测试双向链表
     * @param args
     */
    public static void main6(String[] args) {
        //LinkedList
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addLast(15);
        doubleLinkedList.addFirst(0);

        doubleLinkedList.display();
        doubleLinkedList.addIndex(0,888);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(3,888);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(8,888);
        doubleLinkedList.display();

        doubleLinkedList.removeAllKey(888);
        doubleLinkedList.display();


        doubleLinkedList.clear();
        System.out.println("hello");
    }




    public  static Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp =  newHead;
        //1、当两个单链表都不为空的时候
        while (headA != null && headB != null) {
            if(headA.data < headB.data) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        //2、第一步完成后   其中一个单链表不为空  一个为空
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public static void main5(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(1);
        myLinedList.addLast(2);
        myLinedList.addLast(23);
        myLinedList.addLast(41);
        myLinedList.addLast(63);
        myLinedList.display();

        MyLinedList myLinedList2 = new MyLinedList();
        myLinedList2.addLast(12);
        myLinedList2.addLast(15);
        myLinedList2.addLast(23);
        myLinedList2.addLast(31);
        myLinedList2.addLast(36);
        myLinedList2.addLast(45);
        myLinedList2.addLast(51);
        myLinedList2.addLast(81);
        myLinedList2.display();

        Node ret = mergeTwoLists(myLinedList.head,myLinedList2.head);
        myLinedList.display2(ret);
    }

    public static void main4(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(2);
        myLinedList.addLast(15);
        myLinedList.addLast(1);
        myLinedList.addLast(3);
        myLinedList.addLast(6);
        myLinedList.display();

        myLinedList.createLoop();
        System.out.println(myLinedList.hasCycle());
        System.out.println(myLinedList.detectCycle().data);
    }

    public static void createCut(Node headA, Node headB) {
        headA.next = headB.next.next;
    }


    public static Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;

        Node pL = headA;//代表长的单链表
        Node pS = headB;//代表短的单链表

        while (pL != null) {
            lenA++;
            pL = pL.next;
        }
        while (pS != null) {
            lenB++;
            pS = pS.next;
        }
        //如果不指回来 那么pl和ps是空
        pL = headA;
        pS = headB;

        int len = lenA-lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        //可以保证：
        // 1、pL指向了长的单链表   pS指向了短的单链表
        //2、len的值 是一个正数
        while (len  > 0) {
            pL = pL.next;
            len--;
        }
        //pL 走了差值len步
        while (pL != pS) {
            pS = pS.next;
            pL = pL.next;
        }
        //pL == pS
        if(pL==pS  && pL != null){
            return pL;
        }
        return null;
    }

    public static void main3(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(2);
        myLinedList.addLast(15);
        myLinedList.addLast(1);
        myLinedList.addLast(3);
        myLinedList.addLast(6);
        myLinedList.display();

        MyLinedList myLinedList2 = new MyLinedList();
        myLinedList2.addLast(12);
        myLinedList2.addLast(154);
        myLinedList2.addLast(12);
        myLinedList2.addLast(31);
        myLinedList2.addLast(16);
        myLinedList2.addLast(45);
        myLinedList2.addLast(21);
        myLinedList2.addLast(8);
        myLinedList2.display();

        createCut(myLinedList.head,myLinedList2.head);
        System.out.println("=============================");
        myLinedList.display();
        myLinedList2.display();

        Node ret = getIntersectionNode(myLinedList.head,myLinedList2.head);
        System.out.println(ret.data);

        /*System.out.println("========基准=======");
        Node newHead = myLinedList.partition(4);
        myLinedList.display2(newHead);*/


        /*Node cur = myLinedList.findKthToTail(13);
        System.out.println(cur.data);*/
        /*System.out.println("=======反转=======");
        Node ret = myLinedList.reverseList();
        myLinedList.display2(ret);*/
    }

    public static void main1(String[] args) {
        MyLinedList myLinedList = new MyLinedList();
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.addLast(2);
        myLinedList.display();//5 1 2 3 4
        System.out.println(myLinedList.contains(14));
        System.out.println(myLinedList.size());
        System.out.println("==========删除=========");
        myLinedList.removeAllKey(2);
        myLinedList.display();
    }
}
