/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
 *
 * User:LiWenYan
 * Date:2020-08-26
 * Time:17:21
 */
public class 计算值 {
    public static void main(String[] args) {
        double ret = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            double tmp = 1.0/i;
            ret = ret + flag*tmp;
            flag *= -1;
        }
        System.out.println(ret);
    }
}
