package basics.elementary;

public class Demo {
    public static void main(String[] args){
        //float f = 99.22; 默认小数为double,会报错
        float f = 99.22f;
        double d2 = 1.234e2;// 科学计数法表示double
    }

    public void method1(final int j) {
        //j = 5; //这个能否执行？ 不行
    }

    public void breakDemo(String[] args) {
        //打印单数
        outloop: //outloop这个标示是可以自定义的比如outloop1,ol2,out5
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i+":"+j);
                if(0==j%2)
                    break outloop; //如果是双数，结束外部循环
            }
        }
    }
}
