import java.util.Scanner;
import java.util.Random;
import java.io.IOException;
public class TestDemo3 {
	public static int fac(int a) {
		if(a == 1) {
			return 1;
		}
		return a*fac(a-1);
	}
	public static void main(String[] args) {
		int n = 5;
		int ret = fac(n);
		System.out.println(ret);
	}
	/*public static int max2(int a,int b) {
		return a > b ? a : b;
	}
	public static int max3(int a, int b,int c) {
		
	}
	public static void main10(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		int ret1 = max2(n1,n2);
		int ret2 = max3(n1,n2,n3);
		System.out.println(ret1);
		System.out.println(ret2);
	}*/
	public static void main9(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int rand = random.nextInt(100);
		while(true) {
			int num = scan.nextInt();
			if(num > rand) {
				System.out.println("猜大了");
			}else if(num < rand) {
				System.out.println("猜小了");
			}else {
				System.out.println ("猜对了");
				break;
			}
		}
		System.out.println("游戏结束");
	}
	public static void main8(String[] args) {
		System.out.println("请输入正确的密码，您只有三次机会！");
		Scanner scan = new Scanner(System.in);
		int count = 3;
		while(count != 0) {
			System.out.println("请输入密码：");
			String password = scan.next();
			if(password.equals("123456")) {
				System.out.println("登录成功！");
				break;
			}else {
				count--;
				System.out.println("密码错误！您还有" + count +"次机会！");

			}
		}
	}
	public static void main7(String[] args) {
		Random random = new Random(1234);
		int rand = random.nextInt(100);
		System.out.println("rand: " + rand);
	}
	public static void main6(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			int n = scan.nextInt();
			System.out.println("整型：" + n);
		}
		System.out.println("哈哈哈");
	}
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("整型：" + n);
		/*String name = scan.nextLine();//li wen yan
		System.out.println("姓名：" + name);*/
		//scan.close();
		String name = scan.next();//li
		System.out.println("姓名：" + name);
		double d = scan.nextDouble();
		System.out.println("小数：" + d);
	}
	public static void main4(String[] args) {
		System.out.println("请输入一个字符：");
		try {
			char ch = (char)System.in.read();
			System.out.println(ch);
		}catch(IOException e) {
			System.out.println("程序发生异常了！");
		}
	}
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("输出且换行！");
		System.out.print("输出不换行！");
		System.out.printf("%s\n","格式化输出！");
		System.out.printf("%d\n",n);
		System.out.printf("%x\n",100);
	}
	public static void main2(String[] args) {
		int n=4;
		int i = 1;
		int ret = 1;
		int sum=0;
		while (i <= n) {
			ret=ret*i;
			sum+=ret;
			i++;
		}
		System.out.println(sum);
	}
	public static void main1(String[] args) {
		int i = 1;
		int sum1 = 0;
		int sum2 = 0;
		while (i <= 100) {
			if(i % 2 == 0) {
				sum1 += i;//sum = sum+i;
			}else{
				sum2 += i;
			}
			i++;
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
}