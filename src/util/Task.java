package util;
import java.util.Date;
import java.util.TimerTask;

import Blockchain.IOTA;

public class Task extends TimerTask{
  private String name ;
  private Transaction transaction;
  IOTA iota;

  public Task(String n, Transaction t){
    this.name = n;
    this.transaction = t;
	iota = new IOTA("altnodes.devnet.iota.org","443");
  }

  @Override
  public void run() {
    System.out.println(this.transaction.getId()+" "+this.transaction.getData()+" "+this.transaction.getDate()+" "+name+" the task has executed successfully "+ new Date());
    iota.Connect();
    iota.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
    iota.Send(this.transaction.getData());
  }

}
