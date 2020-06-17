/**
 * 数据类型
 */

public class TestDemo {

	public static void main(String[] args) {
		//short  char
		short sh = 10;
		char ch =  '高';
		//sh = (short)ch;
		ch = sh;
	}


	public static void main10(String[] args) {
		//byte   char
		byte b = 10;
		char ch = '高';
		//找的是9所对应的字符
		//char ch2 = 9; 建议字符就是字符，不要给整型
		//b = (byte)ch;
		ch = (char)b;

		System.out.println(b);
		System.out.println(ch);
		//System.out.println(ch2);

	}

	public static boolean flg;
	public static char ch;

	public static void main9(String[] args) {
		//int a = 10;
		//System.out.println(a);
		System.out.println(flg);
		System.out.println(ch);
	}

	public static void main8(String[] args) {
		//String -> int
		String s1 = "12";
		int a = Integer.parseInt(s1);
		System.out.println(a);
	}


	public static void main7(String[] args) {
		//int -> String
		int a = 10;
		String s1 = a + "";
		System.out.println(s1);
		//String.valueOf-》将参数转化为字符串
		String s2 = String.valueOf(12.5);
		System.out.println(s2);
	}


	public static void main6(String[] args) {
		int a = 10;
		long b = 12L;
		//不同的类型参与运算，提升为较大的那个类型
		long c = a+b;
		System.out.println(c);
		
		int d = 20;
		int e = a+d;
		System.out.println(e);
	}


	public static void main5(String[] args) {
		byte a = 10;
		byte b = 12;
		byte c = (byte)(a+b);
		//int c = a+b;
		System.out.println(c);
	}


	public static void main4(String[] args) {
		int a = 10;
		byte b = 127;
		//a = (int)b;
		//b = a;
		System.out.println(a);
	}

	/**
	 * boolean 不能和其他的类型之间进行转换
	 * @param args [description]
	 */

	public static void main3(String[] args) {
		int a = 10;
		boolean b = true;
		//a = (int)b;
		//b = a;
		System.out.println(a);
	}

	public static void main2(String[] args) {
		int a = 10;
		double b = 12.5;
		//a = (int)b;
		b = a;
		System.out.println(b);
	}

	public static void main1(String[] args) {
		int a = 10;
		long b = 20L;
		//a = (int)b;
		b = a;
		System.out.println(b);
	}
}
