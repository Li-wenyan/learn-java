public class Practice222 {
    public static void main(String[] args) {
        MyArrayList222 myArrayList222 = new MyArrayList222();
        myArrayList222.addLast(4);
        myArrayList222.addLast(2);
        myArrayList222.addLast(3);
        myArrayList222.addLast(1);
        myArrayList222.addLast(5);
        //myArrayList222.addIndex(3,6);
        myArrayList222.display();
        //System.out.println(myArrayList222.contains(1));
        /*myArrayList222.remove(2);
        myArrayList222.display();
        myArrayList222.removeAllKey(2);
        myArrayList222.display();*/
        /*Node2 ret = myArrayList222.reverseList();
        myArrayList222.display2(ret);*/
        /*Node2 tmp = myArrayList222.middleNode();
        System.out.println(tmp.data);*/

        System.out.println(myArrayList222.findKthNode(0).data);
      /*  Node2 ret = myArrayList222.partition(3);
        myArrayList222.display2(ret);*/

    }
}
