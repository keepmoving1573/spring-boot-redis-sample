package sample.data.redis.bean;

import java.io.Serializable;

/**
 * @author <a href="mailto:heikehuan@sina.com">詹欢欢</a>
 * @since 2016/10/26 - 22:41
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -6581670973971319289L;

    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
