package cn.android.j2se.core.thread.synchronizeddemo;

public class Demo1 implements Runnable{
	private Foo foo = new Foo(); 

    public static void main(String[] args) { 
        Demo1 r = new Demo1(); 
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

 class Foo { 
    private int x = 100; 

    public int getX() { 
        return x; 
    } 

    public  int fix(int y) { 
    	synchronized (this) {
    		 x = x - y;  
		}
    	  return x; 
       
    } 
}
