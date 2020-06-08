public class Practice000 {
    public static void main(String[] args) {
        MyArrayList000 myArrayList000 = new MyArrayList000();
        /*myArrayList000.addFirst(1);
        myArrayList000.addFirst(2);
        myArrayList000.addFirst(3);
        myArrayList000.addFirst(4);
        myArrayList000.addFirst(5);
         myArrayList000.display();*/
        myArrayList000.addLast(2);
        myArrayList000.addLast(2);
        myArrayList000.addLast(2);
        myArrayList000.addLast(4);
        myArrayList000.addLast(2);
        myArrayList000.addFirst(2);
        myArrayList000.addIndex(3,7);
        myArrayList000.display();
        System.out.println(myArrayList000.contains(7));
        System.out.println(myArrayList000.size());
        myArrayList000.remove(7);
        myArrayList000.display();
        myArrayList000.removeAllKey(2);
        myArrayList000.display();
    }
}
