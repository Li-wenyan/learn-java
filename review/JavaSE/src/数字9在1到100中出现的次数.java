/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:17:34
 */
public class 数字9在1到100中出现的次数 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }
}
