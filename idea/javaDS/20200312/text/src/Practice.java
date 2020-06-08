import java.sql.SQLOutput;
import java.util.Scanner;

public class Practice {
    /**
     * 递归求： 1+2+3+4+5+.....+n
     * @param n
     * @return
     */
    public static int intSum(int n) {
        if(n == 1) {
            return 1;
        }
        return n + intSum(n-1);
    }
    /**
     * 递归求：n的阶乘
     * @param
     */
    public static int fac(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }

    /**
     * 循环倒序输出一个数的每一位
     * @param
     */
    public static void print(int n) {
        while(n != 0) {
            System.out.println(n % 10);
            n /= 10;
        }
    }

    /**
     * 递归顺序输出一个数的每一位
     * @param
     */
    public static void print1(int n) {
        if(n > 9) {
            print1(n/10);
        }
        System.out.println(n%10);
    }

    /**
     * 返回一个数的每一位之和
     * @param n
     * @return
     */
    public static int sum(int n) {
        if(n == 0) {
           return 0;
        }
        return n%10+sum(n/10);
    }

    /**
     * 递归求斐波那契数第n项
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    /**
     * 循环求斐波那契数第n项
     * @param n
     * @return
     */
    public static int fib1(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for(int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 求解汉诺塔问题
     * @param pos1
     * @param pos3
     */
    public static void move(char pos1,char pos3) {
        System.out.print(pos1+"->"+pos3+" ");
    }
    public static void hanNuoTa(int n,char pos1,char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanNuoTa(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanNuoTa(n-1,pos2,pos1,pos3);
    }
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();*/
        //int ret = intSum(n);
        //int ret = fac(n);
        //System.out.println(ret);
        //print(n);
        //print1(n);
        //int ret = sum(n);
        //int ret = fib(n);
       /* int ret = fib1(n);
        System.out.println(ret);*/

       hanNuoTa(3,'A','B','C');
    }
}
