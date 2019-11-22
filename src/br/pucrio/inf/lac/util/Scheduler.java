package br.pucrio.inf.lac.util;
import java.util.Timer;

public class Scheduler {
	static Timer ti;
	long delay;
	int num_tasks;
	Task newTask;
	
	public Scheduler(String type) {
		newTask = new Task("Task"+num_tasks, type);
		
		ti = new Timer();
		delay = 480000;
		num_tasks = 0;
		
		ti.scheduleAtFixedRate(newTask, delay, 60000);
	}
	
	public void enqueue_in(Transaction t) {
		num_tasks = num_tasks + 1;
		newTask.add(t);
	}

}