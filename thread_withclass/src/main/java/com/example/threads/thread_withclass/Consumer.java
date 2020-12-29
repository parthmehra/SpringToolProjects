package com.example.threads.thread_withclass;

public class Consumer extends Thread {
	QueueClass queue =new QueueClass();

	public void run() {
		
		while (queue.size() != 0) {
		int que = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);
			if (queue.size() > 0) {
				System.out.println(" " + que + " has been consumed.");

			} else {

				System.out.println(" " + que + " has been consumed, Queue is empty ");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
