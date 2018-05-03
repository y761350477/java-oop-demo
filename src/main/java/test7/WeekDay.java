package test7;

public enum WeekDay {
    SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);

    private int value;

    private WeekDay(int value){
        this.value = value;
    }

    public static WeekDay getNextDay(WeekDay nowDay){
        int nextDayValue = nowDay.value;

        if (++nextDayValue == 7){
            nextDayValue = 0;
        }

        return getWeekdayByValue(nextDayValue);
    }

    public static WeekDay getWeekdayByValue(int value) {
        for (WeekDay c : WeekDay.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
}

class Test2{
    public static void main(String[] args) {
        System.out.println("nowday ====> " + WeekDay.SAT);
        System.out.println("nowday int ====> " + WeekDay.SAT.ordinal());
        System.out.println("nextday ====> " + WeekDay.getNextDay(WeekDay.MON)); // 输出 SUN

        // 输出：
        // nowday ====> SAT
        // nowday int ====> 6
        // nextday ====> SUN
    }
}
