package br.pucrio.inf.lac.util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import br.pucrio.inf.lac.Blockchain.Blockchain;
import br.pucrio.inf.lac.Blockchain.IOTA;
import br.pucrio.inf.lac.Blockchain.IoTex;
import br.pucrio.inf.lac.Blockchain.Ethereum;

import jota.model.Transfer;

public class Task extends TimerTask{
  private String name ;
  private String BlockchainType;
  private List<Transaction> transaction;
  private IOTA iota;
  private IoTex iotex;
  private Ethereum eth;
  
  public Task(String n, String type){
    this.name = n;
    this.transaction = new ArrayList<>();
    this.BlockchainType = type;

    if (BlockchainType == "IOTA") {
    	iota = new IOTA("nodes.devnet.thetangle.org","443");
        iota.Connect();
        iota.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");	
    }else if(BlockchainType == "IoTex") {
    	iotex = new IoTex("nodes.devnet.iotex.org","80");
    	iotex.Connect();
    	iotex.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
    }else if(BlockchainType == "Ethereum"){
    	eth = new Ethereum("nodes.devnet.ethereum.org","443");
    	eth.Connect();
    	eth.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
    } else {
    	System.out.println("Blockchain Type not found");
    }   
	
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

		
		if (BlockchainType == "IOTA") {
			iota.Send(transactions_to_send);	
	    }else if(BlockchainType == "IoTex") {
	    	iotex.Send(transactions_to_send);
	    }else if(BlockchainType == "Ethereum"){
	    	eth.Send(transactions_to_send);
	    } else {
	    	System.out.println("Blockchain Type not found");
	    }
	    
	    transactions_to_send.clear();
	}else {
		System.out.println("Sem Novos dados");
	}
  }

}
