package york.com.retrofit2rxjavademo.entity;

/**
 * @author: YorkYu
 * @version: V2.0.0
 * @project: Retrofit2RxjavaDemo
 * @package: york.com.retrofit2rxjavademo.entity
 * @description: description
 * @date: 2017/7/11
 * @time: 17:47
 */
public class TestBean {
    String name;
    int age;

    public TestBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
