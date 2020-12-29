package com.example.threads.thread_withclass;

public class Producer extends Thread {
	QueueClass queue=new QueueClass();
	public void run() {
		
		Integer rand = (int) (Math.random() * 10);
		queue.add(rand);
		System.out.println(" Produced value = " + rand);
	}

}
