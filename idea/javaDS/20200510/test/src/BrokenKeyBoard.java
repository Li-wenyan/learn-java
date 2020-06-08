import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//坏键盘打字
public class BrokenKeyBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //1.处理输入，读取输入字符串
            String expected = scanner.next();
            String actual = scanner.next();
            //2.把两个字符串都转成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            //3.把actual中的字符放到一个set中
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            //4.遍历预期输出的字符串，看这里的字符哪些没有在setActual中出现，没有出现的就是坏键
            Set<Character> brokenKey = new HashSet<>();
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if(setActual.contains(c)) {
                    //存在就不是坏键
                    continue;
                }
                //这是一个坏键，输出。但是不要忘了坏键不需要重复输出
                if (brokenKey.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKey.add(c);
            }
            System.out.println();
        }


    }
}
