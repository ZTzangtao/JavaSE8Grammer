package InitializationSequence;

/**
 * InitialOrderTest
 *
 * @author zangtao
 * @create 2019 - 08 -21 17:34
 */
public class InitialOrderTest {

    public static String staticField = "静态变量";

    static {
        System.out.println("静态语句块");
    }

    public String field = "实例变量";

    {
        System.out.println("普通语句块");
    }

    public InitialOrderTest() {
        System.out.println("构造函数");
    }

    public static void main(String[] args) {
        InitialOrderTest initialOrderTest = new InitialOrderTest();
    }
}
