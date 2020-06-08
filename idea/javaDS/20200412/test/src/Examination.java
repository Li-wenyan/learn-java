import java.util.Scanner;

public class Examination {
    //1.输入一个字符串，求出该字符串包含的字符集合
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(!builder.toString().contains(temp+"")){
                builder.append(temp);
            }
        }
        System.out.println(builder.toString());
    }
}
