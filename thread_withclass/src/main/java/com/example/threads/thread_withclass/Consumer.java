package com.example.threads.thread_withclass;

public class Consumer extends Thread {
	public void run() {
		while(QueueClass.queue.size()==0) {
			System.out.println("Queue is empty, waiting");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		while (QueueClass.queue.size()>0) {
			
			if (QueueClass.queue.size() > 1) {
				
				System.out.println(" " + QueueClass.queue.poll() + " has been consumed.");

			} else if(QueueClass.queue.size()==1) {
		
				System.out.println(" " + QueueClass.queue.poll() + " has been consumed, Queue is empty ");
			}
			else {
				System.out.println("Queue is empty");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
