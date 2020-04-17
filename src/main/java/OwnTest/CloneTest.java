package OwnTest;

/**
 * @author zangtao
 * @date 2020/4/16 9:41
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setAge(18);
        student.setName("zt");
        System.out.println(student.clone());
        System.out.println( student.hashCode());
    }

}
