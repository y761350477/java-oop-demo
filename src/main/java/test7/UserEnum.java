package test7;

/**
 * @author YangChen
 * @create 2017-12-08 16:04
 */
public enum UserEnum {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    private String name ;
    private int index ;

    private UserEnum(String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

}
