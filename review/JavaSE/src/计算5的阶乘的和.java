/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:00
 */
public class 计算5的阶乘的和 {
    public static void main(String[] args) {
        int ret = 0;
        for (int i = 1; i <= 5; i++) {
            int tmp = 1;
            for (int j = 1; j <= i; j++) {
                tmp *= j;
            }
            ret += tmp;
        }
        System.out.println(ret);
    }
}
