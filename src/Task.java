import java.util.Date;
import java.util.TimerTask;

public class Task extends TimerTask{
  private String name ;
  private Transaction transaction;

  public Task(String n, Transaction t){
    this.name = n;
    transaction = t;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()+" "+name+" the task has executed successfully "+ new Date());
  }

}
