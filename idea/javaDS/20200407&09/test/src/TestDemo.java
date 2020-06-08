import java.lang.reflect.Field;
import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /*String str1 = "hehe";
        //intern 方法可以主动去池子中查找，看看当前这个String是否在池中存在
        //如果不在池中，就把这个Sting加入到池中
        //如果已经存在，就可以舍弃当前对象，直接获取到池中的对应对象的引用
        String str2 = new String("hehe").intern();
        System.out.println(str1 == str2);*/

        //反射  修改字符串的内容
       /* String str = "hehe";
        //1.需要先根据“value” 这个名字找到str中内部存储的value数组
        //String.class获取到String类对象  其中包含类名，成员，每个成员的类型和名字.......
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[])field.get(str);
        //2.然后再修改这个数组内容即可
        value[0] = 'a';
        System.out.println(str);*/


        //字符数组与字符串的相互转换，字节数组雷同
        /*char[] array = {'h','e','h','e'};
        //字符-》字符串     使用String的构造函数
        String str = new String(array);
        System.out.println(str);
        //字符串-》字符
        char[] array2 = str.toCharArray();// 1. 使用.toCharArray   相当于把字符串 拷贝 到一个新的字符数组中   拷贝会浪费开销

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("=================");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));//  2. 使用.charAt     更好
        }


        System.out.println(str.charAt(0));//charAt获取到某个下标对应的字符*/




        //1.字符串比较大小
        /*String str1 = "hehe";
        String str2 = "Hehe";
        System.out.println(str1.equals(str2));//b比较是否相等
        System.out.println(str1.equalsIgnoreCase(str2));//忽略大小写
        System.out.println(str1.compareTo(str2));//比较大小（字典序）   >  返回大于0 的值   <  返回小于0的值   =返回0*/



        //2. 字符串查找子串
        /*String str1 = "hello worldwor";
        String str2 = "wor";

        //通过contains方法可以判断是否是包含关系
        System.out.println(str1.contains(str2));

        //通过indexOf方法不仅能判定子串是否存在，还能返回子串在str1中所在的下标位置
        System.out.println(str1.indexOf(str2));//返回最左侧的下标位置
        System.out.println(str1.lastIndexOf(str2));//返回最右侧的下标位置

        //startsWith,endsWith是否以关键字开头或者结尾
        System.out.println(str1.startsWith("hello"));
        System.out.println(str1.endsWith("hello"));*/



        //3.字符串替换
       /* //replaceAll/replaceFirst都不能修改原始的字符串，而是得到新的字符串
        //replaceAll/replaceFirst
        String str1 = "hello world";
        String str2 = "wor";
        String result = str1.replaceAll("world","java");//regex  正则表达式
        System.out.println(str1);
        System.out.println(result);*/



        //4.字符串拆分
       /*String str1 = "aaaa,bbbb,,cccc";
       String[] result = str1.split(",");
       System.out.println(Arrays.toString(result));

       String str2 = "2334.6754.24.89";
       //.在正则表达式中有特定含义，需要用\.来转义从而查找文本.    而java中需要用\\来代表一个文本\
        // 所以.  需要写成   \\.
        //  |  *   +   等都有类似的情况
       String[] result1 = str2.split("\\.");
       System.out.println(Arrays.toString(result1));

       String str = "name=张三&age=18";
       String[] result2 = str.split("&");
       for (String tmp : result2) {
           String[] tmp2 = tmp.split("=");
           System.out.println(tmp2[0] + ":" + tmp2[1]);
       }*/



       //5. 字符串截取子串   substring
        /*String str = "hello world";
        //前闭后开区间
        System.out.println(str.substring(6,9));
        //表示从6开始，一直到结束，都是要截取的内容
        System.out.println(str.substring(6));*/



        //6.其他操作

        /*// a.删除字符串前后的空白字符
        //空白字符：空格，制表符，换行，回车，垂直制表符，翻页符....
        String str = "  \n\t     ab cd    \n  ";
        System.out.println("[" + str + "]");
        System.out.println("[" + str.trim() + "]");*/

        /*//b.大小写转换  不会修改原字符串内容，
        String str = "Hello";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());*/

        //isEmpty判断是否为空字符串“”，而不是判定是否为null


        //7.StringBuffer(线程安全) 和 StringBuilder(线程不安全)

        /*String str = "";
        for (int i = 0; i < 10; i++) {
            str += "abcd";//创建了新的对象
        }
        System.out.println(str);*/
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str.append("abcd");//StringBuilder的append操作就是修改当前字符串，把新内容追加在后面

        }
        System.out.println(str);

    }
}
