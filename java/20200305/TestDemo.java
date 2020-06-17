import java.util.Scanner;
/**
 * 第二个课件的作业：
 * 1、
 * 2、
 * 作者：高博
 * data：20200305
 */
public class TestDemo {

	public static void main(String[] args) {
		//工具类：Scanner
		Scanner scan = new Scanner(System.in);
		//手动输入：
		//1、import java.util.Scanner;
		//2、Scanner scan = new Scanner(System.in);
		//3、scan.nextInt()--》读入一个整型 。
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		int max = a >= b ? a : b;
		int max2 = c >= max ? c : max;
		System.out.println(max2);
		
		/*int max2 = c >= (a >= b ? a : b) ? c : (a >= b ? a : b);
		System.out.println(max2);*/

	}

	public static void main1(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a);
		System.out.println(b);
		System.out.println("===============");
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println(a);
		System.out.println(b);
	}
}

