/*class Base1{

    public Base1(String s){

        System.out.print("B");

    }

}

public class Derived extends Base1{

    public Derived (String s) {

        System.out.print("D");

    }

    public static void main(String[] args){

        new Derived("C");

    }

}*/
/*class X{
    Y y=new Y();
    public X(){
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
public class Derived extends X{
    Y y=new Y();
    public Derived(){
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Derived();
    }
}*/
class B {
    public int Func() {
        System.out.print("B");
        return 0;
    }
}
class D extends B {
    @Override
    public int Func() {
        System.out.print("D");
        return 0;
    }
}
public class Derived {
    public static void main(String[] args) {
        B a = new B();
        B b = new D();
        a.Func();
        b.Func();
    }
}

