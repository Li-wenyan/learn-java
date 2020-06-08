import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {

        //1.实例化一个List
        List<String> list = new ArrayList<>();

        //2. 新增元素
        list.add("C语言");
        list.add("C++");
        list.add("Java");
        list.add("Python");
        list.add("PHP");

        //3.打印整个list
        System.out.println(list);

        //4.使用下标访问
        //【注意】如果当前list是ArrayList，get/set按下标访问的方式，是比较高效的（时间复杂度是o(1)）
        //        如果当前List是LinkedList，get/ set按下标访问就比较低效，时间复杂度是o(N)
        System.out.println("================");
        System.out.println(list.get(0));
        list.set(0,"Go");
        System.out.println(list);

        //5.截取部分内容
        System.out.println(list.subList(1,3));

        //6.重新构造一个List     浅拷贝
        List<String> arrayList = new ArrayList<>(list);
        List<String> linkedList = new LinkedList<>(list);
        System.out.println("=====================");
        System.out.println(arrayList);
        System.out.println(linkedList);

        //7.基于现有的List的引用进行强制类型转换（向下转型）
        ArrayList<String> arrayList1 = (ArrayList<String>)list;
        LinkedList<String> linkedList1 = (LinkedList<String>)list;




    }
}
