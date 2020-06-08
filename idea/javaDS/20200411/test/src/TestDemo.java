

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;


public class TestDemo {



    public static void main(String[] args) {


     /*//Collection接口


        //Collection 是接口，add，remove，contains这些方法都是抽象方法
        //这些方法在执行 时候，具体的行为取决于collection对应的真实对象的类型


        //1. 实例化一个Collection对象，Collection 是一个接口，必须要new一个对应的类作为实例才可以
        Collection<String> collation = new ArrayList<>();

        //2. 使用size/isEmpty
        System.out.println(collation.isEmpty());
        System.out.println(collation.size());

        //3，使用add添加元素
        collation.add("我");
        collation.add("爱");
        collation.add("wuli");

        //4.再次使用isEmpty和size
        System.out.println("==================");
        System.out.println(collation.isEmpty());
        System.out.println(collation.size());

        //5. toArray把集合转换成数组
        //    String也是继承自Object.             array看似是一个Object数组，其实是一个String数组
        System.out.println("===============");
        Object[]  array = collation.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(collation);//重写了toString


        //6.for each 遍历collection
        //比较简单的遍历方式，while或者普通for循环，需要搭配迭代器使用
        System.out.println("======================");
        for (String s : collation) {
            System.out.println(s);
        }


        //7.判定元素是否存在  contains内部会按值比较
        System.out.println("======================");
        System.out.println(collation.contains("我"));


        //8.使用删除方法来删除指定元素
        System.out.println("======================");
        collation.remove("爱");
        for (String s : collation) {
            System.out.println(s);
        }


        //9.使用clear来清空所有的元素
        collation.clear();
        System.out.println(collation.isEmpty());
        System.out.println(collation.size());
*/











        //Map接口

         //1.实例化一个Map
        Map<String,String> map = new HashMap<>();

        //2. isEmpty/size
        System.out.println(map.isEmpty());
        System.out.println(map.size());

        //3.put插入若干个键值对   key => value  反向不行
        map.put("及时雨","宋江");
        map.put("玉麒麟","卢俊义");
        map.put("智多星","吴用");
        map.put("入云龙","公孙胜");
        map.put("行者","李逵");

        //4.使用get  根据key找value
        System.out.println(map.get("及时雨"));
        System.out.println(map.get("行者"));
        //找到key，返回对应value；如果没找到，返回默认值
        System.out.println(map.getOrDefault("行者","武松"));

        //5.使用contains判定元素是否存在
        System.out.println("=======================");
        System.out.println(map.containsKey("及时雨"));//比较高效，  推荐
        System.out.println(map.containsValue("宋江"));//比较低效

        //6.循环遍历Map    此处的Entry表示  条目   一个一个的键值对
        //  对于Map来说，保存的元素顺序和插入顺序无关，有自己的规则
        for(Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //7.clear清空所有元素
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
    }



}
