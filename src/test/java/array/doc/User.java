package array.doc;

/**
 * 用户信息
 *
 * @author YC
 * Created by 2018/5/22 15:41.
 */
public class User {

    /**
     * 名字
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 获取
     * @return 返回名字
     */
    public String getName() {
        return name;
    }

    /**
     * 赋值
     * @param name 名称参数
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return 返回性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 赋值
     * @param sex 性别参数
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}
