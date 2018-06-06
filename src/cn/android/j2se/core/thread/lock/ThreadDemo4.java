package cn.android.j2se.core.thread.lock;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

 class NameList2 {
	 private List nameList = Collections.synchronizedList(new LinkedList()); 

	    public synchronized void add(String name) { 
	        nameList.add(name); 
	    } 

	    public synchronized String removeFirst() { 
	        if (nameList.size() > 0) { 
	            return (String) nameList.remove(0); 
	        } else { 
	            return null; 
	        } 
	    } 
}

public class ThreadDemo4 { 
    public static void main(String[] args) { 
        final NameList2 nl = new NameList2(); 
        nl.add("aaa"); 
        class NameDropper extends Thread{ 
            public void run(){ 
                String name = nl.removeFirst(); 
                System.out.println(name); 
            } 
        } 

        Thread t1 = new NameDropper(); 
        Thread t2 = new NameDropper(); 
        t1.start(); 
        t2.start(); 
    } 
}
