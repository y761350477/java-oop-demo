package pojo;

/**
 * 通用UserBean
 *
 * @author YC
 * Created by 2018-07-13 17:53
 */
public class User {

    private String name;
    private Integer age;
    private String address;
    private String sex;

    public User() {
    }

    public User(String name, Integer age, String address, String sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
