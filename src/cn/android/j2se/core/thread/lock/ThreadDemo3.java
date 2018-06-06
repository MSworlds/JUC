package cn.android.j2se.core.thread.lock;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

 class NameList {
	 private List<String> nameList = Collections.synchronizedList(new LinkedList()); 

	    public void add(String name) { 
	        nameList.add(name); 
	    } 

	    public String removeFirst() { 
	        if (nameList.size() > 0) { 
	            return (String) nameList.remove(0); 
	        } else { 
	            return null; 
	        } 
	    } 
}

public class ThreadDemo3 { 
    public static void main(String[] args) { 
        final NameList nl = new NameList(); 
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
