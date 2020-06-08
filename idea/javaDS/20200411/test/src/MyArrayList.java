import java.util.Objects;

class Student {
    public String name;
    public String sex;
}

public class MyArrayList<E> {
    //Object代替泛型       泛型


    //private E[] array = new E[100];
    private E[] array = (E[])new Objects[100];

    private int size;
    void add(E o) {
        array[size] = o;
        size++;
    }
    E get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
       /* MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("我");
        myArrayList.add("爱");
        myArrayList.add("wuli");
        String ret = (String) myArrayList.get(0);

       MyArrayList myArrayList2 = new MyArrayList();
       myArrayList2.add(new Student());
       myArrayList2.add(new Student());
       myArrayList2.add(new Student());
       String ret2 = (String)myArrayList2.get(0); */

       MyArrayList<String> myArrayList = new MyArrayList<>();
       myArrayList.add("hehe");
       String s = myArrayList.get(0);

       MyArrayList<Student> myArrayList1 = new MyArrayList<>();
       myArrayList1.add(new Student());
       Student student = myArrayList1.get(0);

    }

}
