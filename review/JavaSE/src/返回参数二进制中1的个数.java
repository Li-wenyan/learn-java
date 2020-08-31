import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-28
 * Time:13:15
 */
public class 返回参数二进制中1的个数 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int n = scanner.nextInt();
        int count = 0;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        while (n != 0) {
            int tmp = n & 1;
            if(tmp == 1) {
                count++;
            }
            n = n>>1;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int n = scanner.nextInt();
        int count = 0;
        for (int i = n; i > 0; i /= 2) {
            count += i % 2;
        }
        System.out.println(count);
    }
}
