/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:15:57
 */
public class 计算5的阶乘 {
    public static void main(String[] args) {
        int ret = 1;
        for(int i = 1; i <= 5; i++) {
            ret *= i;
        }
        System.out.println(ret);
    }
}
