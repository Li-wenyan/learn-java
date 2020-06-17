import java.util.Scanner;
import java.util.Random;
public class HomeWork1 {
	//猜数字小游戏
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int rand = random.nextInt(100);
		
		while(true) {
			System.out.println("请输入您要猜的数字：");
			int num = scan.nextInt();
			
			if(num > rand) {
				System.out.println("猜大了！");
			}else if(num < rand) {
				System.out.println("猜小了！");
			}else {
				System.out.println("猜对了！");
				break;
			}
		}
		System.out.println("游戏结束了！");
	}
	//输出一个数的每一位
	public static void main12(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n < 0) {
			System.out.println("-");
			n = -n;
		}
		while(n != 0) {
			int tmp = n % 10;
			System.out.println(tmp);
			n = n / 10;
		}
	}
	//分别输出二进制的偶数位和奇数位
	public static void main11(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 31; i >= 1; i -= 2) {
			System.out.print(((n >>> i) & 1) + " ");
		}
		System.out.println();
		for(int i = 30; i >= 1; i -= 2) {
			System.out.print(((n >>> i) & 1) + " ");
		}
	}
	//二进制中1的个数
	public static void main10(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		/*while(n != 0) {
			if((n & 1) != 0) {
				count++;
			}
			n = n >>> 1;
		}*/
		//方法2
		while(n != 0) {
			count++;
			n = n & (n-1);
		}
		System.out.println(count);
	}
	//模拟用户登录密码
	public static void main9(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入正确的密码，您只有三次机会！");
		int count = 3;
		while(count != 0) {
			System.out.println("请输入正确的密码：");
			String password = scan.next();
			if(password.equals("123456")) {
				System.out.println("登录成功！");
				break;
			}else {
				count--;
				System.out.println("登录失败，您还有"+count+"次机会！");
			}
		}
	}
	//打印0-999999中所有的xxxx数 3位数-》水仙花数  5位数-》五角星数
	public static void main8(String[] args) {
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
				System.out.println(sum);
			}
		}

	}
	//1-100中9出现的次数
	public static void main7(String[] args) {
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 10 == 9) {//个位   十位
				count++;
			}
			if(i / 10 == 9) {
				count++;
			}
		}
		System.out.println("9出现是次数是：" + count);
	}
	//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	public static void main6(String[] args) {
		double sum = 0;
		int flag = 1;
		for(int i = 1; i <= 100; i++) {
			sum += 1.0/i*flag;
			flag = -flag;
		}
		System.out.println(sum);
	}
	//求两个数的最大公约数
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();//18
		int b = scan.nextInt();//24
		int c = a%b;//18
		while(c != 0) {
			a = b;//a=24    a=18
			b = c;//b=18	b=6
			c = a%b;//c=6	c=0
		}
		System.out.println("最大公约数为：" + b);
	}
	//打印乘法口诀表
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j+"*"+i+"="+i*j+" ");
			}
			System.out.println();
		}
	}
	//打印1000到n以内的闰年
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 1000; i <= n; i++){
			if(i%4 == 0 && i%100 != 0 || i%400 == 0) {
				System.out.println(i + "是闰年");
			}
		}
	}
	//判断是否为素数
	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 0;
		for(i = 2; i < n; i++) {
		//法2
		//for(i = 2; i < n/2; i++){
		//法3
		//for(i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i >= n) {
		//法2
		//if(i >= n/2) {
		//法3
		//if(i > Math.sqrt(n)) {
			System.out.println(n + "是素数");
		}
	}
	//
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int oldYear = scan.nextInt();
		if(oldYear <= 18) {
			System.out.println("少年");
		}else if(oldYear >= 19 && oldYear <= 28) {
			System.out.println("青年");
		}else if(oldYear >= 29 && oldYear <= 55) {
			System.out.println("中年");
		}else {
			System.out.println("老年");
		}
	}
}
