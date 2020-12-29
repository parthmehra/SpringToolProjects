package com.example.threads.thread_withclass;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
	
	Queue<Integer> queue= new LinkedList<>();

	public void add(Integer rand) {
		
		queue.add(rand);
	}

	public int size() {
		
		return queue.size();
	}

	public void remove(int i) {
		queue.poll();
		
	}

	public int get(int i) {
		
		return queue.element();
	}
	

}
