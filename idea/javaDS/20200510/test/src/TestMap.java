import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Student {
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
public class TestMap {

    public static void main(String[] args) {
        Student s1 = new Student("蔡徐坤", 20, "大四", "陕科大");
        Student s2 = new Student("蔡蔡", 30, "大三", "西科大");
        Student s3 = new Student("坤坤", 40, "大二", "西安工大");
        Map<String, Student> studentMap = new TreeMap<>();
        studentMap.put(s1.name, s1);
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);
        //当前键值对name-> Student,给定姓名就可以查找到对应的学生信息
        String name = "蔡徐坤";
        Student student = studentMap.get(name);
        System.out.println(student);
        /*Student student2 = studentMap.getOrDefault(name, new Student("默认姓名",
                0, "默认年纪", "默认学校"));
        System.out.println(student2);*/

        Student s4 = new Student("蔡徐坤", 100, "大一", "社会大学");
        studentMap.put(s4.name,s4);
        Student student2 = studentMap.get(name);
        System.out.println(student2);
        //如果想按照其他映射来查找，例如年龄，那就需要其他的map
        /*Map<Integer, Student> studentMap1 = new HashMap<>();
        studentMap1.put(s1.age, s1);
        studentMap1.put(s2.age, s2);
        studentMap1.put(s3.age, s3);
        Student student1 = studentMap1.get(20);
        System.out.println(student1);*/

        //遍历一个Map
        //Entry条目，也就是键值对
        //1.for each
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        //2.迭代器
        Iterator<Map.Entry<String, Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
