import java.util.Scanner;
import java.lang.Math;

public class HomeWork {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();//123
		if(n < 0) {
			System.out.println("-");//递归
			n = -n;
		}
		while(n != 0) {
			int tmp = n % 10;//123%10=3   2   1
			System.out.println(tmp);//递归
			n = n/10;//n = 123/10=12   12/10 =1   1/10=0
		}

	}


	public static void main14(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();//-1

		for (int i = 31; i >= 1; i -= 2) {
			System.out.print (  ((n >>> i) & 1) + " "  );
		}

		System.out.println();

		for (int i = 30; i >= 0; i -= 2) {
			System.out.print (  ((n >>> i) & 1) + " "  );
		}

	}

	public static void main13(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();//-1
		int count = 0;
		while(n != 0) {
			count++;
			n = n & (n-1);
		}
		System.out.println(count);
	}


	public static void main12(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();//-1
		int count = 0;
		while(n != 0) {
			if((n & 1) != 0 ){
				count++;
			}
			n = n>>>1;//针对负数  
		}
		System.out.println(count);
	}



	public static void main11(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count = 3;
		System.out.println("请输入正确的密码，您有3次机会！");
		while(count != 0) {
			System.out.println("请输入正确的密码：");
			String password = scan.next();
			//在java当中，判断两个字符串是否一样使用方法 equals
			//password.equals("123456")
			
			if(password.equals("123456")) {//"=="
			    System.out.println("登录成功！");
			    break;
			}else {
				count--;
				System.out.println("登录失败，你还有 " + count +"次机会！ ");
			}
		}

	}


	public static void main10(String[] args) {
		

		for (int i = 0;i <= 999999 ; i++) {
			//判断每一个数字i是不是xxxx数
			
			//1、判断当前i是几位数
			//123   123/10=12  12/10=1  1/10=0
			//总结：一般用除法--》一直往下除就好了
			int count = 0;//数字的位数
			int tmp = i;//先保存i到tmp
			while (tmp != 0) {
				count++;//1  2  3
				tmp = tmp/10;//123/10=12  12/10=1  1/10=0
			}

			//2、求每个数字i 他的每一位  用于^count运算
			//i= 123         123%10=3  
			//123/10= 12     12%10=2  
			//12/10=1        1%10 = 1
			//i= 1/10=0
			//总结：得到一个数字的某一位， /10%10  %10/10
			tmp = i;
			int sum = 0;
			while (tmp != 0) {
				//sum = sum + (Math.pow(i%10,count));//1^count
				sum += Math.pow(tmp%10,count);//复合运算符-》
				tmp = tmp/10;//123/10 =  12  12/10=1  1/10=0
			}
			//3、sum = 就是每个位上数字的次方和
			if(sum == i) {
				System.out.println(sum + "是要找的数字！");
			}
			
		}

	}


	public static void main9(String[] args) {
		int count = 0;
		for(int i = 1;i <= 100;i++) {
			if(i % 10 == 9) {//个位
				count++;
			}
			if(i / 10 == 9) {//十位
				count++;
			}
		}
		System.out.println("9的个数是： "+ count);
	}

	/**
	 * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	 * @param args [description]
	 */

	public static void main8(String[] args) {
		double sum = 0;
		int flg = 1;
		for (int i = 1; i <= 100;i++ ) {
			sum = sum+ 1.0/i * flg;
			flg = -flg;//-1
		}
		System.out.println("输出sum "+ sum);
	
	}

	public static void main7(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();//18
		int b = scan.nextInt();//24
		int c = a%b;//余数  18 % 24 = 18
		while (c != 0) {
			a = b;//a = 24                a = 18
			b = c;//b = 18                b =  6
			c = a % b;//c = 24 % 18 = 6   c = 0
		}
		System.out.println("最大公约数："+ b);
	}


	public static void main6(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1;i <= n ; i++) {
			for (int j = 1;j <= i ;j++ ) {
				System.out.print (i+"*"+j+"="+i*j +" ");
			}
			System.out.println();
		}

	}

	public static void main5(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1000; i <= n; i++) {
			if(i%4 == 0 && i%100 != 0 || i%400==0) {
				System.out.println(i + " 是闰年 ");
			}
		}

	}

	/**
	 * 素数：只能被1和他本身整除
	 * 3    7    11   
	 * 越简单的东西  坑是越多的
	 * 优化：
	 * 1、  n==8   不是素数   a*b = 8   1  8     2 4
	 *      肯定会有一个数字是小于等于n/2的
	 * 2、  n==8   不是素数   a*b = 8   1  8     2 4    
	 *      肯定会有一个数字是小于等于根号n的
	 *      16    1 16   4  4    2   8
	 * 所有和数学的函数，直接去找一个类：Math
	 * @param args [description]
	 */
	
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int num = 1; num <= n ; num++) {
			//7    1 7    2-6
			int i;
			for (i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					break;
				}
			}

			//程序走到这里的时候，有2中情况：
			//1、循环正常的退出   素数
			//2、因为break        不是素数
			if(i > Math.sqrt(num)) {//i > n || i == n
				System.out.println(num + " 是素数 ");
			}
		}
		
	}
	
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//7    1 7    2-6
		int i;
		for (i = 2; i <= n/2; i++) {
			if(n % i == 0) {
				break;
			}
		}

		//程序走到这里的时候，有2中情况：
		//1、循环正常的退出   素数
		//2、因为break        不是素数
		if(i > n/2) {//i > n || i == n
			System.out.println(n + " 是素数 ");
		}
	}

	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		//7    1 7    2-6
		int i;
		for (i = 2; i < n; i++) {
			if(n % i == 0) {
				break;
			}
		}

		//程序走到这里的时候，有2中情况：
		//1、循环正常的退出   素数
		//2、因为break        不是素数
		if(i >= n) {//i > n || i == n
			System.out.println(n + " 是素数 ");
		}

	}



	/**
	 * 第一题：
	 * @param args [description]
	 */

	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int oldYear = scan.nextInt();

		if(oldYear <= 18) {
			System.out.println("少年");
		}else if (oldYear >= 19 && oldYear <= 28) {
			System.out.println("青年");
		}else if(oldYear >= 29 && oldYear <= 55) {
			System.out.println("中年");
		}else {
			System.out.println("老年");
		}

		//System.out.println("请输入你要猜的数字：");
	}
}