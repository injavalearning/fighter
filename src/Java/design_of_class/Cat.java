package Java.design_of_class;

/**
 * 本例是父类引用指向子类对象的讲解，cat是子类
 */
public class Cat extends Animal {
    public int num = 80;
    public static int age = 90;
    public String name = "tomcat";

    public void eat(){
        System.out.println("猫吃饭");
    }
    public static void sleep(){
        System.out.println("猫睡觉");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
