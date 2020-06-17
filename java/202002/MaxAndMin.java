public class MaxAndMin {
	public static void main(String[] args) {
		int max=1;
		int mid=88;
		int min=66;
		if(max>mid) {

		}
		else {
			int tem=max;
			max=mid;
			mid=tem;
		} 
		if(mid>min) {

		}
		else {
			int tem=mid;
			mid=min;
			min=tem;
		}
		if(max>mid) {

		}
		else {
			int tem=max;
			max=mid;
			mid=tem;
		}
		System.out.println(max + "," + min);
	}
}