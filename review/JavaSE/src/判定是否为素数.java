import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:16:09
 */
public class 判定是否为素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            sushu(n);
        }
    }
    public static void sushu(int n) {
        if (n == 1) {
            System.out.println("该数不是素数");
            return;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if(n % i == 0) {
                System.out.println("该数不是素数");
                return;
            }
        }
        System.out.println("该数是素数");
    }
}
