public class MyTextDome {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,30);
        myArrayList.display();
        System.out.println("=============");
        myArrayList.add(3,40);
        myArrayList.display();
       /* System.out.println(myArrayList.contains(20));
        System.out.println(myArrayList.search(20));
        System.out.println(myArrayList.getPos(1));
        myArrayList.remove(30);
        myArrayList.display();
        myArrayList.clear();
        myArrayList.display();*/


    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] array2 = new int[] {1,2,3};
        int[] array3 = new int[8];
        array3[3] = 9;
    }
}
