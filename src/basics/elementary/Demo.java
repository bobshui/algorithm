package basics.elementary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {

    }

    //一些零散的小知识点
    public void demo(final int j) {
        //j = 5; //这个能否执行？ 不行
        //float f = 99.22; 默认小数为double,会报错
        float f = 99.22f;
        double d2 = 1.234e2;// 科学计数法表示double
    }

    public void breakDemo(String[] args) {
        //break默认跳出内层循环，如果要跳出外层，需进行单独的标示
        n:
        for (int i = 0; i < 10; i++) {
            m:
            for (int j = 0; j < 10; j++) {
                System.out.println(i + ":" + j);
                if (0 == j % 2)
                    break n; //如果是双数，结束外部循环
            }
        }
    }

    public void yuanmaDemo() {
        //用于研究list collection iterator 源码
        ArrayList list = new ArrayList();
        list.add("计算机网络");
        list.add("现代操作系统");
        list.add("java编程思想");
        list.add("java核心技术");
        list.add("java语言程序设计");
        System.out.println(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String next = (String) it.next();
            System.out.println(next);
        }

        StringBuilder stringBuilder = new StringBuilder();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
        String timeText = formatter.format(c.getTimeInMillis());
    }
}
