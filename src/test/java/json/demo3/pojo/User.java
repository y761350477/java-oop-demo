package json.demo3.pojo;

/**
 * bean模版
 *
 * @author YC
 * Created by 2018-07-02 15:35
 */
public class User {

    private String name;
    private String sex;

    public User() {
    }

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
