import java.util.Scanner;
public class HomeWork {
	//14.调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序
	public static void main13(String[] args) {
		int []arr={1,2,3,4,5,6,7,8,9,10};
        int i;
        int j;
        for(i=0;i<10;i++){
            for(j=i+1;j<10;j++){
	            if(arr[j]%2!=0){
	                int tmp=arr[j];
	                arr[j]=arr[i];
	                arr[i]=tmp;
	            }
        	} 
        	System.out.print(arr[i]+" ");
      	}
	}
	//13.有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
	public static void main12(String[] args) {
		int []arr={1,1,2,2,4,3,4,5,5};
        int i=0;
        int j=0;
        int count;
        for(i=0;i<9;i++){
            count =0;
            for(j=0;j<9;j++){
                if(arr[i]==arr[j])
                    count ++;
                
            }if(count==1){
                System.out.println(arr[i]);
            }
        }
	}
	//12.在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
	public static int sum3(int a, int b) {
		return a + b;
	}
	public static double sum3(double a, double b,double c) {
		return a + b + c;
	}
	public static void main11(String[] args) {
		int a = 10;
		int b = 50;
		double c = 15.5;
		double d = 52.1;
		double e = 13.14;
		int ret1 = sum3(a,b);
		double ret2 = sum3(c,d,e);
		System.out.println(ret1);
		System.out.println(ret2);
	}
	//11.在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
	//还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
	public static int reload(int a, int b) {
		return a > b ? a : b;
	}
	public static double reload(double a, double b) {
		return a > b ? a : b;
	}
	public static double reload(int a, double b, double c) {
		double ret = reload(b,c);
		return a > ret ? a : ret;
	}
	public static void main10(String[] args) {
		int a = 10;
		int b = 50;
		double c = 15.5;
		double d = 52.1;
		int ret1 = reload(a,b);
		double ret2 = reload(c,d);
		double ret3 = reload(a,c,d);
		System.out.println(ret1);
		System.out.println(ret2);
		System.out.println(ret3);
	}
	//10.创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
	//要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
	public static int max2(int a, int b) {
		return a > b ? a : b;
	}
	public static int max3(int a, int b,int c) {
		return max2(max2(a,b),c);
	}
	public static void main9(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int ret = max3(a,b,c);
		System.out.println("最大值为：" + ret);
	}
	//9.求1！+2！+3！+4！+........+n!的和
	public static int facSum(int n) {
		if(n == 1) {
			return 1;
		}
		return fac(n) + facSum(n - 1);
	}
	public static void main8(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = facSum(n);
		System.out.println(ret); 
	}
	//8.青蛙跳台阶问题(与斐波那契数列相同)
	public static int fibNum1(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		return fibNum1(n-1)+fibNum1(n-2);
	}
	public static void main7(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = fibNum1(n);
		System.out.println(ret);
	}
	//7.求解汉诺塔问题
	/**
	 * 
	 * @param n 盘标号
	 * @param x 源位置
	 * @param z 目的位置
	 */
	public static void move(int num,String x, String z){
		System.out.println("第"+i+++"步，将"+num+"号盘子从"+x+"移动到"+z);
	}
	
	/**
	 * 
	 * @param num 		盘标号
	 * @param x 		”A“
	 * @param y 	”B“
	 * @param z 		”C“
	 */
	public static void hanoi(int num,String x, String y, String z){
		if(num == 1){
			move(1,x,z);			//一个盘子时，直接从x移动z
		}else{
			hanoi(num-1,x,z,y);//将num-1个盘子从x移动y，借助z
			move(num,x,z);			//将当前最大的盘子num从x移动到z
			hanoi(num-1,y,x,z);//将num-1个盘子从y移动z，借助x
		}
	}  
	private static int i = 1;//记录执行的次数
	public static void main6(String[] args) {
		int num;//盘子的个数
		try {
			System.out.print("请输入盘子的个数：");
			Scanner input = new Scanner(System.in);
			num = input.nextInt();
			String x="A",y="B",z="C";//定义三座塔
			hanoi(num,x,y,z);
		} catch (Exception e) {
			System.out.println("请输入正整数！");
		}
	}
	//6.求斐波那契数列的第 N 项Fibonacci number
	public static int fibNum(int n) {
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 1;
		}
		return fibNum(n-1)+fibNum(n-2);
	}
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = fibNum(n);
		System.out.println(ret);
	}
	//5.写一个递归方法，输入一个非负整数，返回组成它的数字之和
	public static int sum2(int n) {
		if(n == 0) {
			return 0;
		}
		return n % 10 + sum2(n/10);
	}
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();//123
		/*int a=n%10;//3
		int b=n/10%10;//2
		int c=n/10/10%10;//1
		int sum=a+b+c;*/
		int ret = sum2(n);
		System.out.println(ret);
	}
	//4.按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
	public static void printNum(int n) {
		if(n > 9) {
			printNum(n/10);
		}
		System.out.print(n%10 + " ");
	}
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		printNum(n); 
		System.out.println();
	}
	//3.递归求 1 + 2 + 3 + ... + 10
	public static int sum1(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sum1(n-1);
	}
	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = sum1(n);
		System.out.println(ret);
	}
	//2.递归求n的阶乘
	public static int fac(int n) {
		if(n == 1) {
			return 1;
		}
		return n * fac(n - 1);
	}
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ret = fac(n);
		System.out.println(n + "阶乘为：" + ret);
	}
}