package OwnTest;

import lombok.Data;

import java.util.Objects;

/**
 * @author zangtao
 * @date 2020/4/16 9:44
 */
@Data
public class Student implements Cloneable  {
    private String name;
    private Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                age.equals(student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
