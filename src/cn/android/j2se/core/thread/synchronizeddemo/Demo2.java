package cn.android.j2se.core.thread.synchronizeddemo;

public class Demo2 implements Runnable{
	private Foo2 foo = new Foo2(); 

    public static void main(String[] args) { 
        Demo2 r = new Demo2(); 
        Thread ta = new Thread(r, "Thread-A"); 
        Thread tb = new Thread(r, "Thread-B"); 
        ta.start(); 
        tb.start(); 
    } 

    public void run() { 
        for (int i = 0; i < 3; i++) { 
            this.fix(30); 
            try { 
                Thread.sleep(1); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(Thread.currentThread().getName() + " : 当前foo对象的x值= " + foo.getX()); 
        } 
    } 

    public int fix(int y) { 
        return foo.fix(y); 
    } 
}

 class Foo2 { 
    private int x = 100; 

    public int getX() { 
        return x; 
    } 

    public int fix(int y) { 
        x = x - y; 
        return x; 
    } 
}
