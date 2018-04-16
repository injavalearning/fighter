package Java.design_of_class;

/**
 * 本例是父类引用指向子类对象的讲解，Test_Polymorphism是测试类
 */
public class Test_Polymorphism {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();                      // 猫吃饭，子类重写了方法
        a.sleep();                    // 动物睡觉，a只能访问自己类中static修饰的方法
        a.run();                      // 动物奔跑，子类未重写
        //a.catchMouse();             // a不能访问子类新定义的方法

        System.out.println(a.num);    // 10，a只能访问自己类声明的变量
        System.out.println(a.age);    // 20
        //System.out.println(a.name); //
    }
}
