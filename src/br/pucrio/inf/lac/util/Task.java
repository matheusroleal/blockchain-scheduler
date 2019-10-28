package br.pucrio.inf.lac.util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import br.pucrio.inf.lac.Blockchain.IOTA;
import jota.model.Transfer;

public class Task extends TimerTask{
  private String name ;
  private List<Transaction> transaction;
  IOTA iota;

  public Task(String n){
    this.name = n;
    this.transaction = new ArrayList<>();
	
    iota = new IOTA("nodes.devnet.thetangle.org","443");
    iota.Connect();
    iota.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
  }
  
  public void add(Transaction t) {
	  this.transaction.add(t);
  }

  @Override
  public void run() {
	if( this.transaction.size() > 0) {
		// INIT -- Período de testes		
		System.out.println("Novos dados");
		// END -- Período de testes
		
		List<Transaction> transactions_to_send = this.transaction;
		this.transaction.clear();

		// INIT -- Período de testes		
		System.out.println(this.transaction.size());
		System.out.println(transactions_to_send.size());
		// END -- Período de testes		

		iota.Send(transactions_to_send);
	    
	    transactions_to_send.clear();
	}else {
		System.out.println("Sem Novos dados");
	}
  }

}
