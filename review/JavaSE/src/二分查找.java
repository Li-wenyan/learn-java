
/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-30
 * Time:19:47
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(MybinarySearch(arr, 6));
    }

    private static int MybinarySearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(i < arr[mid]) {
                right = mid-1;
            }else if (i > arr[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
