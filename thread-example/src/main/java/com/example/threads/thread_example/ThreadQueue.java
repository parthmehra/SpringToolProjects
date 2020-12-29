package com.example.threads.thread_example;

import java.util.ArrayList;



public class ThreadQueue extends Thread {
	public static void main(String[] args) throws InterruptedException

	{
		final AddToQueue add = new AddToQueue();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
			System.out.print("1. ");
				add.produce();
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.print("2. ");
				add.produce();
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.print("3. ");
				add.produce();
			}
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.print("4. ");
				add.produce();
			}
		});
		Thread t5 = new Thread(new Runnable() {

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
		Thread.sleep(500);
		t2.start();
		Thread.sleep(500);
		t3.start();
		Thread.sleep(500);
		t4.start();
		Thread.sleep(500);
		t5.start();
	}
}

class AddToQueue extends Thread {
	ArrayList<Integer> queue = new ArrayList<Integer>();
	
	public void produce() {
		 {
			Integer rand = (int) (Math.random() * 10);
			queue.add(rand);
			System.out.println(" Produced value = " + rand + queue);
		}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(500);
		while (queue.size() > 0) {
			int que = queue.get(queue.size()-1);
			queue.remove(queue.size() - 1);
			if(queue.size()>0){
				System.out.println(" " + que + " has been consumed." + queue);
				
			}
			else {
				
				System.out.println(" " + que + " has been consumed, Queue is empty " );
			}
			Thread.sleep(500);

		}

	}
}
