import java.util.Scanner;
import java.util.Random;
public class Practice {
	//判断最大公约数
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();//24
		int b = scan.nextInt();//18
		int c = a%b;//6
		while(c != 0) {
			a = b;
			b = c;
			c = a%b;
		}
		System.out.println(b);
	}
	//判断n是否为素数
	public static void main9(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		/*for(i = 2; i < n; i++) {
			if(n % i == 0){
				break;
			}
		}
		if(i >= n) {
			System.out.println(n+"是素数");
				
		}*/
		/*for(i = 2; i < n/2; i++) {
			if(n % i == 0){
				break;
			}
		}
		if(i >= n/2) {
			System.out.println(n+"是素数");
				
		}*/
		for(i = 2; i < Math.sqrt(n); i++) {
			if(n % i == 0){
				break;
			}
		}
		if(i >= Math.sqrt(n)) {
			System.out.println(n+"是素数");
				
		}
	}

	//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	public static void main8(String[] args) {
		int flag = 1;
		double sum = 0;
		for(int i = 1; i <= 100; i++) {
			double ret = 1.0 / i * flag;
			sum += ret;
			flag = -flag;
		}
		System.out.println(sum);
	}
	//打印1-100中9出现的次数
	public static void main7(String[] args) {
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 10 == 9) {
				count++;
			}
			if(i / 10 == 9) {
				count++;
			}
		}
		System.out.println(count);
	}
	//打印0-999999中所有的xxx数，3位数-水仙花数
	public static void main6(String[] args) {
		for(int i = 0; i <= 999999; i++) {
			int count = 0;
			int tmp = i;
			while(tmp != 0) {
				count++;
				tmp /= 10;
			}
			tmp = i;
			int sum = 0;
			while(tmp != 0) {
				sum += Math.pow(tmp%10,count);
				tmp /= 10;
			}
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
	//输出二进制中1的个数
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		/*while(n != 0) {
			if((n & 1) != 0) {
				count++;
				
			}
			n = n >>> 1;
		}*/
		while(n != 0) {
			count++;
			n = n & (n-1);
		}
		System.out.println(count);
	}
	//分别输出二进制的奇数位和偶数位
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 31; i >= 0; i -= 2) {
			System.out.print(((n>>>i)&1)+" ");
		}
		System.out.println();
		for(int i = 30; i >= 0; i -= 2) {
			System.out.print(((n>>>i)&1)+" ");
		}
	}
	//输出一个数的每一位
	public static void main3(String[] atgs) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n < 0) {
			System.out.print("- ");
			n = -n;
		}
		while(n != 0) {
			System.out.print(n%10+" ");
			n /= 10;
		}
	}
	//猜数字的小游戏
	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int rand = random.nextInt(100);
		System.out.println("请输入你要猜的数字:");
		while(true) {
			int n = scan.nextInt();
			if(n > rand) {
				System.out.println("猜大了，请重输：");
			}else if(n < rand) {
				System.out.println("猜小了，请重输：");
			}else {
				System.out.println("恭喜你，猜对了！");
				break;
			}
		}
	}
	//模拟用户登录密码
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入正确的密码，您只有三次机会！");
		int count = 3;
		while(count > 0) {
			System.out.println("请输入正确的密码：");
			String possword = scan.next();
			if(possword.equals("123456")) {
				System.out.println("登录成功！");
				break;
			}else {
				count--;
				System.out.println("登录失败，您还有"+ count+"次机会");
			}
		}
	}
}