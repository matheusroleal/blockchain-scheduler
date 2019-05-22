import java.util.Timer;

public class Scheduler {
	static Timer ti;
	long delay;
	int num_tasks;
	
	public Scheduler() {
      ti = new Timer();
      delay = 10000;
      num_tasks = 0;
	}
	
	public void enqueue_in(Transaction t) {
		Task newTask = new Task("Task"+num_tasks, t);
		ti.schedule(newTask, delay);
		num_tasks = num_tasks + 1;
	}

}