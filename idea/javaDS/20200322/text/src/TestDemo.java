/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-22
 * Time: 11:03
 */


public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,10);
        myArrayList.add(1,20);
        myArrayList.add(2,40);
        myArrayList.display();//10 20 40
        System.out.println("=======grow==============");
        myArrayList.add(2,99);//10 20 99 40
        myArrayList.display();
       /* System.out.println(myArrayList.getPos(2));
        System.out.println("删除");
        myArrayList.remove(20);
        myArrayList.display();
        System.out.println("=======clear==============");
        myArrayList.clear();
        myArrayList.display();*/
    }


    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};//大小为6的   都放满了
        int[] array2 = new int[]{1,2,3};
        int[] array3 = new int[4];
        array3[2] = 9;
    }
}
