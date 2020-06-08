public class Animal {
    public String name;
    protected String sex;
    public Animal(String name) {
        this.name = name;
    }
    public Animal(String name,String str) {
        this.name = name;
    }
    public void eat() {
        System.out.println(this.name + "  正在吃！");
    }
}
