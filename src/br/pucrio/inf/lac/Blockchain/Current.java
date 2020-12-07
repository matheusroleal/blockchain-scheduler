package br.pucrio.inf.lac.Blockchain;

import java.util.List;

import br.pucrio.inf.lac.util.Transaction;

public class Current {
	static Current instance;
	
	private IOTA iota;
	private IoTex iotex;
	private Ethereum eth;
	
	private static String BlockchainType;
	
	public Current() {
		if (BlockchainType == "IOTA") {
	    
			iota = new IOTA("altnodes.devnet.iota.org","443");
	        iota.Connect();
	        iota.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");	
	    
		} else if(BlockchainType == "IoTex") {
	    
	    	iotex = new IoTex("nodes.devnet.iotex.org","80");
	    	iotex.Connect();
	    	iotex.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
	    
	    } else if(BlockchainType == "Ethereum"){
	    
	    	eth = new Ethereum("nodes.devnet.ethereum.org","443");
	    	eth.Connect();
	    	eth.Configure("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPDX");
	    
	    } else {
	    	
	    	System.out.println("Blockchain Type not found");
	    
	    }
    }
	
	public void Connected() {
		System.out.println("Checking blockchain connection...ß");
	}
	
	public void Send(List<Transaction> transactions_to_send) {
		if (BlockchainType == "IOTA") {
			
			iota.Send(transactions_to_send);	
	    
		} else if(BlockchainType == "IoTex") {
	    
			iotex.Send(transactions_to_send);
	    
		} else if(BlockchainType == "Ethereum"){
	    
			eth.Send(transactions_to_send);
	    
		} else {
	    	System.out.println("Blockchain Type not found");
	    }
	}
	
    public static Current getCurrent(String Blockchain) {
    	BlockchainType = Blockchain;
    	
        if (instance == null) {
        	instance = new Current();
        }
        return instance;
    }

}
