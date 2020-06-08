public class Practice111 {

    public static Node mergeTwoLists(Node headA, Node headB) {
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

    public static void main(String[] args) {

    }


    public static void main2(String[] args) {
        MyArrayList111 myArrayList111 = new MyArrayList111();
        myArrayList111.addLast(1);
        myArrayList111.addLast(2);
        myArrayList111.addLast(3);
        myArrayList111.addLast(4);
        myArrayList111.addLast(5);
        myArrayList111.display();
        myArrayList111.createLoop();
        System.out.println(myArrayList111.hasCycle());
        System.out.println(myArrayList111.detectCycle().data);
    }



    public static void createCut(Node1 headA,Node1 headB) {
        headA.next = headB.next.next;
    }
    //输入两个链表，找出它们的第一个公共结点
    public static Node1 publicNode(Node1 headA,Node1 headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Node1 pL = headA;
        Node1 pS = headB;
        int lenA = 0;
        int lenB = 0;
        while(pL != null) {
            lenA++;
            pL = pL.next;
        }
        while(pS != null) {
            lenB++;
            pS = pS.next;
        }
        pL = headA;
        pS = headB;
        int len = lenA - lenB;
        if(len < 0) {
            pL = headB;
            pS = headA;
            len = -len;
        }
        //可以保证：1，pL指向了长的单链表，pS指向短的;2,len的值是一个正数

        //1,先让长的走差值步，然后一人一步；
        while(len > 0) {
            pL = pL.next;
            len--;
        }
        while(pS != pL) {
            pL = pL.next;
            pS = pS.next;

        }
        if(pS!= null && pS == pL) {
            return pS;
        }
        return null;
    }
    public static void main1(String[] args) {
        MyArrayList111 myArrayList111 = new MyArrayList111();
        myArrayList111.addLast(1);
        myArrayList111.addLast(2);
        myArrayList111.addLast(3);
        myArrayList111.addLast(4);
        myArrayList111.addFirst(5);
        myArrayList111.display();
        System.out.println("======================");
        MyArrayList111 myArrayList1112 = new MyArrayList111();
        myArrayList1112.addLast(45);
        myArrayList1112.addLast(23);
        myArrayList1112.addLast(73);
        myArrayList1112.addLast(42);
        myArrayList1112.addFirst(58);
        myArrayList1112.addFirst(35);
        myArrayList1112.addFirst(18);
        myArrayList1112.display();

        createCut(myArrayList111.head,myArrayList1112.head);
        System.out.println("================");
        myArrayList111.display();
        Node1 ret = publicNode(myArrayList111.head,myArrayList1112.head);
        System.out.println(ret.data);


        /*Node ret = myArrayList111.reverseList();
        myArrayList111.display2(ret);*/
        //System.out.println(myArrayList111.findKthToTail1(4).data);
       /* Node1 newHead = myArrayList111.partition(3);
        myArrayList111.display2(newHead);*/

    /*    myArrayList111.addIndex(2,2);
        myArrayList111.display();
        System.out.println(myArrayList111.contains(5));
        myArrayList111.remove(5);
        myArrayList111.display();
        System.out.println("================");
        myArrayList111.removeAllKey(2);
        myArrayList111.display();
        myArrayList111.clear();
        myArrayList111.display();*/
    }
}
