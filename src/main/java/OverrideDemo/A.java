package OverrideDemo;

/**
 * A
 *
 * @author zangtao
 * @create 2019 - 08 -21 16:48
 */
public class A {
    public void show(A obj) {
        System.out.println("A.show(A)");
    }

    public void show(C obj) {
        System.out.println("A.show(C)");
    }
}
