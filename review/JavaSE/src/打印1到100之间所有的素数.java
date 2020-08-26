/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:19
 */
public class 打印1到100之间所有的素数 {
    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
             if(sushu(i)) {
                 System.out.print(i + " ");
             }
        }
    }
    public static boolean sushu(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
