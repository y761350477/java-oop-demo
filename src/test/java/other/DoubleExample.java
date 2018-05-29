package other;

import org.junit.jupiter.api.Test;

public class DoubleExample {

    /**
     * public boolean isNaN()����
     * public static boolean isNaN(double parameters)����
     * ����NaN��public static final double NaN��������һ��double,����������
     *  ����:
     *  1. Double.isNaN(parameters)parametersֻ��Ϊdouble����,����ж�"����ֵ".
     *  2. Double.isNaN(parameters)��ʲôʹ������?
     *  ����:
     *  1. ����doubleΪ����NaN,���ڽ�������;
     *  2. ����������������double�ı��������Ƿ�ΪNaN���ж�,������Ӧ���߼�;
     *  3. NaNΪ����ֵ.
     *  4. double x = Double.NaN; -> ���xΪNaN.
     *
     * @author YC
     * @create 2018/5/21 15:15.
     */
    @Test
    void test1() {
        // public boolean isNaN()
        double x = Double.NaN;
        Double d1 = new Double(x);
        boolean dou = d1.isNaN();
        System.out.println(dou);

        // public static boolean isNaN(double parameters)
        boolean b = Double.isNaN(x);
        System.out.println(b);
    }
}
