package Java.design_of_class;

/**
 * 本例是父类引用指向子类对象的讲解，Animal是父类
 */
public class Animal {
    public int num = 10;
    public static int age = 20;

    public void eat(){
        System.out.println("动物吃饭");
    }
    public static void sleep(){
        System.out.println("动物睡觉");
    }
    public void run(){
        System.out.println("动物奔跑");
    }
}
