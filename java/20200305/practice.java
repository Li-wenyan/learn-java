public class practice {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while(i <= 100) {
			sum += i;
			i++;
		}
		System.out.println("1-100的和为：" + sum);
		int i = 1;
		int sumOdd = 0;
		while(i <= 100) {
			sumOdd += i;
			i += 2;
		}
		System.out.println("1-100的奇数和为：" + sumOdd);
	}
	public static void main1(String[] args) {
		int num = 5;
		int i = 1;
		while(i<=num) {
			System.out.println(i+" ");
			i++;
		}
	}
}