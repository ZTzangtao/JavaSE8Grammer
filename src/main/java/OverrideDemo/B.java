package OverrideDemo;

/**
 * B
 *
 * @author zangtao
 * @create 2019 - 08 -21 16:49
 */
public class B extends A {
    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }
}
