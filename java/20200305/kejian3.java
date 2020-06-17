import java.util.Scanner;
public class kejian3 {
	public static void main(String[] args) {
		//13.输出一个整数的每一位
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int a=0;
		for(int i=n;i!=0;i/=10) {
				a=i%10;
				System.out.print(a+" ");
		}
	}
	 public static void main12(String[] args) {
	 	//12.获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
	 	Scanner scan = new Scanner(System.in);
	 	int n=scan.nextInt();
	 	int i=0;
	 	for(i=31;i>=1;i-=2) {
	 		System.out.print(((n>>i) & 1) +" ");
	 	}
	 	System.out.println();
	 	for(i=30;i>=1;i-=2) {
	 		System.out.print(((n>>i) & 1) +" ");
	 	}
	 }
	public static void main11(String[] args) {
		//11.写一个函数返回参数二进制中 1 的个数 
		//比如： 15 0000 1111 4 个 1
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int sum=0;
		while(n!=0) {
			if(n%2==1) {
				sum++;
				n/=2;
			}
		}
		System.out.println(sum);
	}
	public static void main9(String[] args) {
		//9.求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，
		//其各位数字的立方和确好等于该数本身，如；153＝1＋5＋3?，
		//则153是一个“水仙花数”。)
		int a=0;
		int b=0;
		int c=0;
		for(int i=0;i<1000;i++) {
			a=i/100;
			b=(i-100*a)/10;
			c=i-100*a-10*b;//c=(i-100*a)%10;
			if((a*a*a+b*b*b+c*c*c)==i) {
				System.out.print(i+" ");
			}
		}
	}
	public static void main8(String[] args) {
		//8.编写程序数一下 1到 100 的所有整数中出现多少个数字9
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i/10==9) {
				sum+=1;
			} 
			if(i%10==9){
				sum+=1;
			}
		}
		System.out.println(sum);
	}

	public static void main7(String[] args) {
		//7.计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
		double temp=0;
		double sum=0;
		int flag=1;
		for(int i=1;i<=100;i++) {
			temp=flag*1.0/i;
			flag*=-1;
			sum+=temp;
		}
		//方法2
		/*double sum=0;
		int i=1;
		for(;i<=100;i++){
			if(i%2==1){
				sum+=1.0/(double)i;
			}else if(i%2==0){
				sum-=1.0/(double)i;
			}*/
		System.out.println(sum);
	}
	public static void main6(String[] args) {
		//6.求两个正整数的最大公约数
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int min=a>b?a:b;
		for(int i=min;i>0;i--) {
			if(a%i==0 && b%i==0) {
				System.out.println(i);
				break;
			}
		}
	}
	public static void main5(String[] args) {
		//5.输出乘法口诀表
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+j*i+" ");
			}
			System.out.println();
		}
	}
	public static void main4(String[] ards) {
		//4.输出 1000 - 2000 之间所有的闰年
		for(int year=1000;year<=2000;year++) {
			if(year%4==0 && year%100!=0 || year%400==0) {
				System.out.print(year+" ");
			}
		}
	}
	public static void main3(String[] args) {
		//3.打印 1 - 100 之间所有的素数
		for(int n=1;n<=100;n++) {
			for(int i=2;i<n;i++) {
			if(n%i==0) {
				break;
			}else {
				System.out.print(n+" ");
				break;
			}
			}
			continue;
		}
		
	} 
		
	public static void main2(String[] args) {
		//2.判定一个数字是否是素数
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				System.out.println("该数字不是素数！");
				break;
			}else {
				System.out.println("该数字是素数！");
				break;
			}
		}
	}
	public static void main1(String[] args) {
		//1.根据年龄, 来打印出当前年龄的人是少年(低于18),
		//青年(19-28), 中年(29-55), 老年(56以上)
		System.out.println("请输入一个整数年龄！");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n>0 && n<=18) {
			System.out.println("当前年龄的人是少年！");
		}else if(n>18 && n<=28) {
			System.out.println("当前年龄的人是青年！");
		}else if(n>28 && n<=55) {
			System.out.println("当前年龄的人是中年！");
		}else if(n>55) {
			System.out.println("当前年龄的人是老年！");
		}else {
			System.out.println("您的输入有误！");
		}
	}
}