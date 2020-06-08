public class PracticeDoubleLineList {
    public static void main(String[] args) {
        DoubleLinedList doubleLinedList = new DoubleLinedList();
        doubleLinedList.addFirst(1);
        doubleLinedList.addFirst(2);
        doubleLinedList.addFirst(3);
        doubleLinedList.addFirst(4);
        doubleLinedList.addFirst(5);
        doubleLinedList.addFirst(6);
        doubleLinedList.display();
        /*doubleLinedList.addIndex(0,999);
        doubleLinedList.display();
        doubleLinedList.addIndex(3,888);
        doubleLinedList.display();
        doubleLinedList.addIndex(8,777);
        doubleLinedList.display();*/
        System.out.println(doubleLinedList.contains(888));
    }
}
