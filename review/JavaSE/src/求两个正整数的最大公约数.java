import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:54
 */
public class 求两个正整数的最大公约数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个正整数：");
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int min = a < b ? a : b;
            for (int i = min; i > 0; i--) {
                if(a % i == 0 && b % i == 0) {
                    System.out.println("最大公约数为：" + i);
                    return;
                }
            }
        }
    }
}
