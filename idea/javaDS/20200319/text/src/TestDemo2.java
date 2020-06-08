/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-19
 * Time: 20:30
 */
class Student {
    private String name;
    private int age;

    //构造方法！没有返回值
    public Student() {
        this("bit",18);//调用带有两个参数的构造方法
        System.out.println("Student()");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* public static void func() {
        this.name = "bit";
    }*/

    //alt+insert（F12）    fn+esc --》 打开

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void func() {
        this.getAge();
    }
}
public class TestDemo2 {

    public static void main(String[] args) {
        Student student = new Student("gaobo",18);//3
        System.out.println(student.getName());

        Student student2 = new Student();
        System.out.println(student2.getName());
        System.out.println(student2.getAge());

    }

    public static void main1(String[] args) {
        Student student = new Student();
        student.setAge(99);
        System.out.println(student.getAge());//99
        System.out.println("=======================");
        student.setName("caocao");
        System.out.println(student.getName());
    }
}
