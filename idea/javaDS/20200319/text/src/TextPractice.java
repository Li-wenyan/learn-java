class Text {
    public int a;
    public static int count;
}
public class TextPractice {
    public static void main(String[] args) {
        Text t1 = new Text();
        t1.a++;
        Text.count++;
        System.out.println(t1.a);
        System.out.println(Text.count);
        System.out.println("=======================");
        Text t2 = new Text();
        t2.a++;
        Text.count++;
        System.out.println(t1.a);
        System.out.println(Text.count);
    }
}
