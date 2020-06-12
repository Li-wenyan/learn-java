package web0611;

public class ThreadDemo22 {
    //先创建一个表示单例的类
    //要求Singleton这个类只能有一个实例
    //饿汉模式的单例实现,"饿"是指只有类被加载，实例就立刻创建（实例创建时机比较早）
    static class Singleton {
        //把构造方法变成私有，此时在该类外部就无法new这个类的实例了
        private Singleton() {

        }
        //再来创建一个static的成员，表示Singleton类的唯一实例
        //static   和 类相关，和实例无关，类在内存中只有一份，static成员也就只有一份
        private static Singleton instance = new Singleton();
        public static Singleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        //此处的getInstance就是获取该类实例的唯一方式，不应该使用其他方式来创建实例
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
    }

}
