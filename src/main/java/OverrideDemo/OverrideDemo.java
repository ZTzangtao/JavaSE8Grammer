package OverrideDemo;

/**
 * 重写练习
 *
 * @author zangtao
 * @create 2019 - 08 -21 16:48
 */
public class OverrideDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.show(a);

        // 在 A 中不存在 show(B obj)，将 B 转型成其父类 A
        a.show(b);

        b.show(c);

        // 在 B 中不存在 show(D obj)，但是存在从 A 继承来的 show(C obj)，将 D 转型成其父类 C
        b.show(d);

        // 引用的还是 B 对象，所以 ba 和 b 的调用结果一样
        A ba = new B();

        ba.show(c);

        ba.show(d);
    }
}
