package test7;

/**
 * 为什么使用枚举类型的例子
 *
 * @author YangChen
 * @create 2017-12-08 16:59
 */
public class WhyUseEnum {

    private WhyUseEnum() {
    }

    public final static WhyUseEnum SUN = new WhyUseEnum();
    public final static WhyUseEnum MON = new WhyUseEnum();
    public final static WhyUseEnum TUE = new WhyUseEnum();
    public final static WhyUseEnum WED = new WhyUseEnum();
    public final static WhyUseEnum THU = new WhyUseEnum();
    public final static WhyUseEnum FRI = new WhyUseEnum();
    public final static WhyUseEnum SAT = new WhyUseEnum();

    public static WhyUseEnum getNextDay(WhyUseEnum nowDay) {
        if (nowDay == SUN) {
            return MON;
        } else if (nowDay == MON) {
            return TUE;
        } else if (nowDay == TUE) {
            return WED;
        } else if (nowDay == WED) {
            return THU;
        } else if (nowDay == THU) {
            return FRI;
        } else if (nowDay == FRI) {
            return SAT;
        } else {
            return SUN;
        }
    }

    public static void printNowDay(WhyUseEnum nowDay) {
        if (nowDay == SUN) {
            System.out.println("sunday");
        } else if (nowDay == MON) {
            System.out.println("monday");
        } else if (nowDay == TUE) {
            System.out.println("tuesday");
        } else if (nowDay == WED) {
            System.out.println("wednesday");
        } else if (nowDay == THU) {
            System.out.println("thursday");
        } else if (nowDay == FRI) {
            System.out.println("friday");
        } else {
            System.out.println("saturday");
        }
    }

    public static int toInt(WhyUseEnum nowDay) {
        if (nowDay == SUN) {
            return 0;
        } else if (nowDay == MON) {
            return 1;
        } else if (nowDay == TUE) {
            return 2;
        } else if (nowDay == WED) {
            return 3;
        } else if (nowDay == THU) {
            return 4;
        } else if (nowDay == FRI) {
            return 5;
        } else {
            return 6;
        }
    }

}

class Test1 {
    public static void main(String[] args) {
        WhyUseEnum nowday = WhyUseEnum.SUN;
        WhyUseEnum.printNowDay(nowday);
        WhyUseEnum nextDay = WhyUseEnum.getNextDay(nowday);
        System.out.print("nextday ====> ");
        WhyUseEnum.printNowDay(nextDay);
    }
}
