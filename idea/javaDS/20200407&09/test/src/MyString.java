import java.util.Arrays;

public class MyString {
    public static void main(String[] args) {
        String str1 = "hehe";
        String str2 = new String("hehe");
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
        char[] ch1 = str1.toCharArray();
        System.out.println(Arrays.toString(ch1));
        System.out.println("=============================");
        System.out.println(str1.contains("he"));
        System.out.println(str1.indexOf("he"));
        System.out.println(str1.lastIndexOf("he"));
        System.out.println("=============================");
        System.out.println(str1.replaceAll("e","a"));
        System.out.println(str1.replaceFirst("e", "a"));
        String[] ret3 = str1.split("e");
        System.out.println(Arrays.toString(ret3));
        System.out.println("=============================");
        System.out.println(str1.substring(1, 3));
        String str3 = "   \n   hehe   \n\t          ";
        System.out.println(str3.trim());
        System.out.println(str1.isEmpty());
        System.out.println(str1.length());
    }
}
