import java.util.Scanner;
public class Practice {
	//递归求n的阶乘
	public static int fac1(int n) {
		if(n == 1) {
			return 1;
		}
		return n * fac1(n-1);
	}
	//循环求1+2+3+4+5+...+n
	public static int faction1(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	//递归求1+2+3+4+5+...+n
	public static int faction(int n) {
		if( n == 1) {
			return 1;
		}
		return n + faction(n-1);
	}
	public static void main4(String[] args) {
		/*int n = 10;
		int ret = faction(n);
		System.out.println(ret);*/
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = fac1(n);
		System.out.println(ret);
	}
	public static int add(int a,int b) {
		return a + b;
	}
	public static double add(double a,double b) {
		return a + b;
	}
	public static int add(int a,int b,int c) {
		return a + b +c;
	}
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int ret = add(a,b);
		System.out.println("两个数的和是："+ret);
		/*double a = 52.1;
		double b = 13.14;
		double ret = add(a,b);
		System.out.println("两个数的和为：" + ret);*/
	}
	//交换失败
	public static void swap(int a,int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}                        
	public static  void main2(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("交换前：a="+a+",b="+b);
		swap(a,b);
		System.out.println("交换后：a="+a+",b="+b);
	}
	//循环求阶乘和
	public static int facSum1(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			int ret = 1;
			for (int j = 1; j <=i; j++) {
				ret *= j;
			}
			sum += ret;
		}
		return sum;
	}
	//递归求阶乘和
	public static int fac(int n) {
		if(n == 1) {
			return 1;
		}
		return n*fac(n-1);
	}
	/*public static int facSum(int n) {
		int sum = 0;
		for(int i = 1;i <= n; i++) {
			sum = sum + fac(i);
		}
		return sum;
	}*/
	public static int facSum(int n) {
		if(n == 1) {
			return 1;
		}
		return fac(n) + facSum(n-1); 
	}
	//求最大值
	public static int max2(int a,int b) {
		return a > b ? a : b;
	}
	public static int max3(int a,int b,int c) {
		return max2(max2(a,b),c);
	}
	//计算1+2+3+4+5+...+n
	public static int addSum(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			  sum += i;
		}
		return sum;
	}
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*int n = scan.nextInt();
		int ret = facSum1(n);
		System.out.println(ret);*/
		/*int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		int ret = max3(n1,n2,n3);
		System.out.println("最大值："+ret);*/
		/*int ret = facSum(n1);
		System.out.println("阶乘和：" + ret);*/
		int n = 10;
		int ret = addSum(n);
		System.out.println(8*ret);
	}
}