import java.util.Arrays;


/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-30
 * Time:20:11
 */
public class 数组逆序 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        int left = 0;
        int rigth = arr.length - 1;
        while (left < rigth) {
            int tmp = arr[left];
            arr[left] = arr[rigth];
            arr[rigth] = tmp;
            left++;
            rigth--;
        }
    }
}
