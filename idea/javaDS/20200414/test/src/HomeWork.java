public class HomeWork {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);
        //System.out.println(myLinkedList.size());
        //myLinkedList.print();
        /*myLinkedList.addAtIndex(5,6);
        myLinkedList.print();*/
        /*myLinkedList.deleteIndex(5);
        myLinkedList.print();*/
        System.out.println(myLinkedList.get(4));
    }
}
