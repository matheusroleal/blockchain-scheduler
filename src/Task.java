import java.util.Date;
import java.util.TimerTask;

public class Task extends TimerTask{
  private String name ;
  private Transaction transaction;

  public Task(String n, Transaction t){
    this.name = n;
    this.transaction = t;
  }

  @Override
  public void run() {
    System.out.println(this.transaction.getId()+" "+this.transaction.getData()+" "+this.transaction.getDate()+" "+name+" the task has executed successfully "+ new Date());
  }

}
