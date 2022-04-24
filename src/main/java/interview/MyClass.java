package interview;

import java.io.File;
import java.io.FileReader;

/**
 * @Author: Tommy
 * @DATE: 2022/4/4
 */
public class MyClass {

    File aFile;
    MyClass(){
        MyOtherClass otherClass = new MyOtherClass();
    }
}
class MyOtherClass {
    FileReader aReader;
    MyOtherClass(){}
}
