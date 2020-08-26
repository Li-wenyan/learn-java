/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:15:32
 */
public class 交换两个变量的值 {
    public static void main1(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a + " " +b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a + " " +b);
    }
    public static void main2(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a + " " +b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " +b);
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a + " " +b);
        a = a ^ b;//按位异或。相同为0，不同为1
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " +b);
    }
}
