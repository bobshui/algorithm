package basics.elementary.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("主线程...");

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("主线程运行结束!");

        Callable callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            FutureTask task = new FutureTask(callable);
            new Thread(task,"子线程"+ i).start();
            try {
                //获取子线程的返回值
                System.out.println("子线程返回值："+task.get() + "\n");
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

