/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:45
 */
public class 输出1000到2000之间所有的闰年 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 2000; i++) {
            if(i % 4 == 0 && i % 100 != 0 || i % 400 ==0) {
                System.out.print(i + " ");
            }
        }
    }
}
