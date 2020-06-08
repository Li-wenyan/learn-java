import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return o1-o2;
            }
        });
        for(int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                return queue.peek();
            }
            int A = queue.poll();
            int B = queue.poll();
            int C = A - B;
            if(C != 0) {
                queue.offer(C);
            }
        }
        return 0;
    }
}
