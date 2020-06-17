/**
 * 运算符：
 * Author:
 * Data:
 * 描述：
 */

/*

 */



public class TestDemo2 {

	public static void main(String[] args) {
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

		//计算1-100偶数的和
		
		//计算1-100奇数的和
	}
	public static void main(String[] args) {
		//System.out.println(10 > 20 && 10 / 0 == 0);
		//System.out.println(10 < 20 || 10 / 0 == 0);

		//System.out.println(10 > 20 & 10 / 0 == 0);
		//System.out.println(10 < 20 | 10 / 0 == 0);不建议使用
		int a=3;
		byte b=a;
		System.out.println(b);//

	}

	public static void main9(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(!(a < b));
		boolean flg = false;
		System.out.println(!flg);
	}

	public static void main8(String[] args) {
		int a = 1;
		int b = 2;
		boolean flg1 = true;
		boolean flg2 = true;
		System.out.println(flg1 && flg2);
		
	}

	public static void main7(String[] args) {
		//关系运算符
		int a = 10;
		int b = 20;
		System.out.println(a == b);//false
		System.out.println(a != b);//true
		System.out.println(a < b);//true
		System.out.println(a > b);//false
		System.out.println(a <= b);//true 
		System.out.println(a >= b);//false
	}

	public static void main6(String[] args) {
		int i = 10;
		i = i++;//C:11  Java 10
		System.out.println(i);//
	}

	public static void main5(String[] args) {
		int i = 10;
		int a = ++i;//i=i+1;  a = i;
		System.out.println(a);//11
		System.out.println(i);//11
	}

	public static void main4(String[] args) {
		int i = 10;
		int a = i++;//a = i; i=i+1;
		System.out.println(a);//10
		System.out.println(i);//11
	}


	public static void main3(String[] args) {
		//System.out.println(5/0);
		System.out.println(11.5%2.0);
	}

	public static void main2(String[] args) {
		System.out.println(10%3);
		System.out.println(10%-3);
		System.out.println(-10%3);
		System.out.println(-10%-3);
	}


	public static void main1(String[] args) {
		System.out.println(5/2);//2
		System.out.println(5.0/2);
		System.out.println(5/2.0);
		System.out.println(5.0/2.0);
	}
}