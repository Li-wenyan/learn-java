import java.util.ArrayList;
import java.util.List;

public class HomeWork<T> {
        T value;

        HomeWork(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }

        public static void main(String[] args) {
            HomeWork homeWork = new HomeWork("wuli");
            System.out.println(homeWork.get());
            System.out.println(homeWork.equals("Wuli"));
        }
}

//public class HomeWork {
    /*public class T {}
    public class A extends T{}
    public class B extends A{}

    public static void main(String[] args){
        List<Class<? extends T>> list = new ArrayList<>();
    }*/



//}
