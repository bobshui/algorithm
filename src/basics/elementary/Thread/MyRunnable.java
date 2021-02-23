package basics.elementary.Thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("执行子线程...");
    }
}