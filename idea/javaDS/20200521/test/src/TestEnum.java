import java.util.Arrays;

//MALE ,FEMALE    都可以理解成Sex类型的对象
//enum 可以理解成是一种特殊的类，这个类中没有属性，也没有成员（只有一些内置的属性方法）
enum Sex {
    MALE,
    FEMALE,
    UNKNOWN,

}
public class TestEnum {
    public static void main(String[] args) {
        Sex s= Sex.MALE;
        System.out.println(s);
        //不能写成
        //Sex s2 = new Sex();

        //Sex.values()得到一个数组，数组中的元素就是当前这个枚举中所有可能的选项
        System.out.println(Arrays.toString(Sex.values()));
    }
}
