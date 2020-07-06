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
}
