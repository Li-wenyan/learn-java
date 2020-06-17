public class Practice {
    public static void main1(String[] args) {
        //打印args数组当中的数据

        for(int i = 0;i < args.length;i++) {
            System.out.print(args[i]+" ");
        }

       System.out.println("HelloWorld");
    }

    public static void main(String[] args) {
        System.out.println(MaxAndMin(23, 5, 89));

    }
    public static String MaxAndMin(int max, int mid, int min) {
        /*if(max>mid) {

        }*/
        if(max < mid) {
            int tmp = max;
            max = mid;
            mid = tmp;
        }
        if(mid < min) {
            int tmp = mid;
            mid = min;
            min = tmp;
        }
        if(max < mid ) {
            int tmp = max;
            max = mid;
            mid = tmp;
        }
        return max + " " + min;
    }

}
