/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:50
 */
public class 输出乘法口诀表 {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i*j + " ");
            }
            System.out.println();
        }
    }
}
