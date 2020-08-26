/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:15:46
 */
public class 求最大最小值 {
    public static void main(String[] args) {
        int a = 66;
        int b = 99;
        int c = 88;
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if(b < c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        System.out.println("max= " + a + ", min= " + c);
    }
}
