import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Practice {
    //判断字符串是否合法（括号是否匹配）
    public Boolean isValid(String s) {
        if(s.isEmpty()) {
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        //给定key能找到value
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        //1,创建一个栈
        Stack<Character> stack = new Stack<>();
        //2,循环遍历字符串，取出字符看是左括号还是右括号
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //(a) 如果是左括号直接入栈
            if(map.get(c) != null) {
                stack.push(c);
                continue;
            }
            //b)如果是右括号，取栈顶元素，看是否和当前元素匹配
            if(stack.empty()) {
                return false;
            }
            Character top = stack.pop();
            //判断括号是否匹配
            /*if (top == '(' && c == ')') {
                //合法情况1
                continue;
            }
            if (top == '{' && c == '}') {
                //合法情况2
                continue;
            }
            if(top == '[' && c == ']') {
                //合法情况3
                continue;
            }*/
            if (map.get(c).equals(top)) {
                continue;
            }
            return false;
        }
        //最后一步，当字符串遍历结束后，看栈是否为空
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
