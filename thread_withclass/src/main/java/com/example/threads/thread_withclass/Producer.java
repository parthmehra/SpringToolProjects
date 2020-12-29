package com.example.threads.thread_withclass;

public class Producer extends Thread {

	public void run() {
		synchronized (QueueClass.queue) {

			Integer rand = null;

			for (int i = 0; i < 5; i++) {
				rand = (int) (Math.random() * 10);
				QueueClass.queue.add(rand);
				System.out.println(" Produced value = " + rand);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
