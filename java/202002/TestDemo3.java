public class TestDemo3 {
	public static void main(String[] args) {
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