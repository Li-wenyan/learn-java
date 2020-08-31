import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-28
 * Time:13:35
 */
public class 获取一个数二进制序列中所有的偶数位和奇数位分别输出二进制序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请出入一个整数：");
        int n = scanner.nextInt();
        System.out.println("偶数序列");
        for (int i = 31; i > 0; i -= 2) {
            System.out.print((n>>i)&1);
        }
        System.out.println();
        System.out.println("奇数序列");
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print((n>>i)&1);
        }
    }
}
