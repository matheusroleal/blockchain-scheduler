package br.pucrio.inf.lac.util;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import br.pucrio.inf.lac.Blockchain.IOTA;
import br.pucrio.inf.lac.Blockchain.IoTex;
import br.pucrio.inf.lac.Blockchain.Current;
import br.pucrio.inf.lac.Blockchain.Ethereum;

public class Task extends TimerTask{
  private String name ;
  private String BlockchainType;
  private List<Transaction> transaction;
  
  public Task(String n, String type){
    this.name = n;
    this.transaction = new ArrayList<>();
    this.BlockchainType = type;
    
    Current.getCurrent(BlockchainType).Connected(); 
	
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

		Current.getCurrent(BlockchainType).Send(transactions_to_send);
	    
	    transactions_to_send.clear();
	}else {
		System.out.println("Sem Novos dados");
	}
  }

}
