import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
    /*static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //如果认为o1的优先级比o2高，则先出o1，让compare返回 < 0 的整数
            //如果认为o2的优先级比o1高，则先出o2，让compare返回 > 0 的整数
            //如果o1和o2一样高，返回0；
            return o2 - o1;//大的先出
            //return o1 - o2;//小的先出
        }
    }*/
    public static void main(String[] args) {
        //这个代码中创建了一个匿名内部类
        //此处不知道这个类名是啥，但是知道这个类实现了Comparator接口
        /*PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/
        //lambda表达式相当于一个匿名方法
        //(o1, o2) -> o2-o1等效为
        //(Integer o1, Integero2) -> {
        //     return o2-o1；
        // }
        // 代码看起来不好理解，主要是省略的东西太多了

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }
}
