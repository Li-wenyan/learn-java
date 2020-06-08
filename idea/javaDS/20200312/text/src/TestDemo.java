import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 361     409     433
 * User: GAOBO
 * Date: 2020-03-12
 * Time: 18:47
 */
public class  TestDemo {
    /**
     * @param n
     * @return
     */
    public static int sumAdd(int n) {
        if(n == 1) {
            return 1;
        }
        return n+sumAdd(n-1);
    }
    //5!  5 * 4!
    public static int fac(int n) {
        System.out.println("函数开始, n = " + n);
        if(n == 1) {
            System.out.println("函数结束, n = " + n);
            return 1;
        }
        int ret = n * fac(n - 1);
        System.out.println("函数结束, n = " + n + " ret = " + ret);
        return ret;
    }

    /**
     * 循环写：%10/10
     * 123: 3   2   1
     * @param num
     */
    public static void print1(int num) {
        while(num!=0) {
            System.out.println(num%10);
            num=num/10;
        }
    }
    //1 2 3   123/10 = 12   12/10 = 1     1
    public static void print(int num) {
        if(num > 9) {
            print(num/10);//123/10 = 12   12/10=  1     1
        }
        System.out.println(num%10);//1%10=1
    }

    /**
     * num : 1729
     * 9 + 2 + sum(17)
     * 9 + 2 + 7 + 1
     * @param num
     * @return
     */
    public static int sum(int num) {
        if(num < 10) {
            return num;
        }
        return num%10 + sum(num/10);
    }

    public static int fabonacio(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        return fabonacio(n-1)+fabonacio(n-2);
    }

    /**
     * 循环实现斐波那契数列
     * @param n
     */
    public static int fabonacio2(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3; i <= n ; i++) {
            f3 = f1+f2;//2
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 1;  A-> C                1  2^1-1
     * 2:  A->B   A-> C  B->C    3   2^2  -1
     * 3: A->C A->B  C->B  A->C  B->A  B->C  A->C     7   2^3 -1
     * 64 :   2^64  -1
     */
    public static void move(char pos1,char pos3) {
        System.out.print(pos1+"->"+pos3+" ");
    }

    public static void hanoi(int n,char pos1,char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);//开始位置,中途转接位置,目的位置
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);//开始位置,中途转接位置,目的位置
    }

    public static void main(String[] args) {
        hanoi(1,'A','B','C');
        System.out.println();
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fabonacio2(n));*/
    }
}
