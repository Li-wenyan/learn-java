import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-28
 * Time:15:11
 */
public class 输出一个整数的每一位 {
    //逆序打印
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = scanner.nextInt();
        while (n != 0) {
            int ret = n % 10;
            n = n / 10;
            System.out.println(ret);
        }

    }*/
    //顺序打印
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n = scanner.nextInt();
        PrintNum(n);
    }

    private static void PrintNum(int n) {
        if(n > 9) {
            PrintNum(n / 10);
        }
        System.out.println(n % 10);
    }
}
