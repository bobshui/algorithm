package CodeInterview.Questions;

/*
题目：设计一个类，我们只能生成该类的一个实例
 */

public class Q02_Singleton {

}

//确保多线程下创建一个实例，两次判断提高效率，懒汉式
class Singleton1{
    private Singleton1(){
    }

    private static Object lock = new Object();
    private static volatile Singleton1 instance = null; //应对极限情况下的读写时间差，有必要加上volatile关键字

    public static Singleton1 getInstance(){
        if(instance == null){
            synchronized (lock){
            //synchronized (Singleton1.class) 也是一样的
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}

//很简单，但是存在过早创建实例占用内存的问题，饿汉式
class Singleton2{
    private Singleton2(){
    }

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance(){
        return instance;
    }
}

//能否和书中一样，使用内部类来实现？高级饿汉式
class Singleton3{
    private Singleton3(){
    }

    //只有调用到的时候，才会初始化Nested类
    private static class Nested{
        public static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return Nested.instance;
    }
}

//Effective Java作者Josh Bloch提倡的方式，似乎也没有任何弱点，线程安全有美感
//同时，串行化后也不影响线程安全，具体可参考https://www.cnblogs.com/z00377750/p/9177097.html
//---关于串行化为何会影响线程安全，待研究
enum Singleton4{
    instance;
    public void otherMethods(){
        System.out.println("Something");
    }
}

//网络上还有使用ThreadLocal，CAS锁等，似乎过于复杂了
//---ThreadLocal，CAS锁