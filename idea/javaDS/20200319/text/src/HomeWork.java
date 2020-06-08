/*class Test1 {
    public static void hello() {
        System.out.println("hello");
    }
}

public class HomeWork {
    public static void main1(String[] args) {
        // TODO Auto-generated method stub
        Test1 test = null;
        test.hello();
    }
}*/
public  class HomeWork {
    public  int aMethod(){
        static int i = 0;
        i++;
        return i;
    }
    public static void main(String args[]){
        HomeWork test = new HomeWork();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
/*public class HomeWork{
    static boolean Paddy;
    public static void main(String args[]){
        System.out.println(Paddy);
    }
}*/
public class HomeWork {

    private int count;

    public static void main(String[] args) {

        HomeWork test=new HomeWork(88);

        System.out.println(test.count);

    }

    HomeWork(int a) {

        count=a;

    }

}
/*public class HomeWork {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        HomeWork hsl = new HomeWork();// 4
        hsl.x++;// 5
        HomeWork hs2 = new HomeWork();// 6
        hs2.x++;// 7
        hsl = new HomeWork();// 8
        hsl.x++;// 9
        HomeWork.x--;// 10
        System.out.println(" x=" + x);// 11
    }
}*/
/*public class HomeWork{

    private String name = "Person";

    int age=0;

}

public class Child extends HomeWork{

    public String grade;

    public static void main(String[] args){

        HomeWork p = new Child();

        System.out.println(p.name);

    }

}*/
