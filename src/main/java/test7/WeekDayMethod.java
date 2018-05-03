package test7;

/**
 * 枚举类型的常用方法的使用
 *
 * 1/使用的是enum关键字而不是class。
 * 2/多个枚举变量直接用逗号隔开。
 * 3/枚举变量最好大写，多个单词之间使用”_”隔开（比如：INT_SUM）。
 * 4/定义完所有的变量后，以分号结束，如果只有枚举变量，而没有自定义变量，分号可以省略（例如上面的代码就忽略了分号）。
 * 5/在其他类中使用enum变量的时候，只需要【类名.变量名】就可以了，和使用静态变量一样。
 * @author YangChen
 * @create 2017-12-13 15:06
 */
public enum WeekDayMethod {
    SUN,MON,TUS,WED,THU,FRI,SAT;
}

class Test3{
    public static void main(String[] args) {

        /*
         * valueOf()方法的使用
         * 它的作用是传来一个字符串，然后将它转变为对应的枚举变量。前提是你传的字符串和定义枚举变量的字符串一模一样，区分大小写。如果你传了一个不存在的字符串，那么会抛出异常。
         */
        System.out.println(WeekDayMethod.valueOf("mon".toUpperCase()));
        // MON

        /*
         * values()方法的使用
         * 这个方法会返回包括所有枚举变量的数组。在该例中，返回的就是包含了七个星期的Weekday[]。可以方便的用来做循环。
         *
         * .ordinal()方法的使用
         * 默认情况下，枚举类会给所有的枚举变量一个默认的次序，该次序从0开始，类似于数组的下标。而.ordinal()方法就是获取这个次序（或者说下标）
         */
        for (WeekDayMethod w : WeekDayMethod.values()){
            System.out.println(w + ".ordinal()  ====> " +w.ordinal());
        }
        // SUN.ordinal()  ====>0
        // MON.ordinal()  ====>1
        // TUS.ordinal()  ====>2
        // WED.ordinal()  ====>3
        // THU.ordinal()  ====>4
        // FRI.ordinal()  ====>5
        // SAT.ordinal()  ====>6

        /*
         * compareTo()方法的使用
         * 该方法用来比较两个枚举变量的”大小”，实际上比较的是两个枚举变量的次序，返回两个次序相减后的结果，如果为负数，就证明变量1”小于”变量2 （变量1.compareTo(变量2)，返回【变量1.ordinal() - 变量2.ordinal()】）
         */
        System.out.println("WeekDayMethod.MON.compareTo(WeekDayMethod.FRI) ===> " + WeekDayMethod.MON.compareTo(WeekDayMethod.FRI));
        System.out.println("WeekDayMethod.MON.compareTo(WeekDayMethod.MON) ===> " + WeekDayMethod.MON.compareTo(WeekDayMethod.MON));
        System.out.println("WeekDayMethod.MON.compareTo(WeekDayMethod.SUM) ===> " + WeekDayMethod.MON.compareTo(WeekDayMethod.SUN));
        // WeekDayMethod.MON.compareTo(WeekDayMethod.FRI) ===> -4
        // WeekDayMethod.MON.compareTo(WeekDayMethod.MON) ===> 0
        // WeekDayMethod.MON.compareTo(WeekDayMethod.SUM) ===> 1

        /*
         * name()方法的使用
         * 它和toString()方法的返回值一样，事实上，这两个方法本来就是一样的：这两个方法的默认实现是一样的，唯一的区别是，你可以重写toString方法。name变量就是枚举变量的字符串形式。
         */
        System.out.println("WeekDayMethod.MON.name() ====> " + WeekDayMethod.MON.name());
        // WeekDayMethod.MON.name() ====> MON

    }
}
