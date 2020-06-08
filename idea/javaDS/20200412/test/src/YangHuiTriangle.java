import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate ( int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) {
            return result;
        }
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2) {
            return result;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> prevLine = result.get(i-1-1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int j = 2; j <= i-1; j++) {
                int tmp1 = prevLine.get(j-1-1);
                int tmp2 = prevLine.get(j-1);
                curLine.add(tmp1+tmp2);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;

    }
}
