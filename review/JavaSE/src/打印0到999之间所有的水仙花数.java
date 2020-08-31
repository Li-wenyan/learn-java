/**
 * Created with IntelliJ IDEA
 * Description:
 * User:LiWenYan
 * Date:2020-08-26
 * Time:17:42
 */
//水仙花数只是自幂数的一种，严格来说3位数的3次幂数才称为水仙花数
// 一位自幂数：独身数
//两位自幂数：没有
//三位自幂数：水仙花数。
public class 打印0到999之间所有的水仙花数 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int a = i % 10;
            int b = (i / 10) % 10;
            int c = i / 100;
            if(i == a*a*a + b*b*b + c*c*c) {
                System.out.println(i);
            }
        }
    }
}
