package com.example.threads.thread_withclass;

public class ThreadWithClass extends Thread
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
        Thread t1=new Producer();
        Thread t2=new Producer();
        Thread t3=new Producer();
        Thread t4=new Producer();
        Thread t5=new Consumer();
        
        t1.start();
   
        t2.start();
   
        t3.start();
      
        t4.start();
     
        t5.start();
    }
}
