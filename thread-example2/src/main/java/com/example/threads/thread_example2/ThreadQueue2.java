package com.example.threads.thread_example2;

import java.util.LinkedList;
import java.util.Queue;


public class ThreadQueue2 extends Thread implements Runnable {
	public static void main(String[] args) throws InterruptedException

	{
		final AddToQueue add = new AddToQueue();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
//			System.out.print("1. ");
				try {
					add.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					add.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		
		t2.start();
		
		
	}

	
}

class AddToQueue extends Thread {
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public void produce() throws InterruptedException {
		 for(int i=0;i<4;i++) {
			Integer rand = (int) (Math.random() * 10);
			
			queue.add(rand);
			System.out.println(i+1 + ". Produced value = " + rand);
			Thread.sleep(1);
		}
	}

	public void consume() throws InterruptedException {
		
		while (queue.size() > 0) {
			System.out.println(" " + queue.poll() + " has been consumed.");		
			Thread.sleep(1);
		}

	}
}

