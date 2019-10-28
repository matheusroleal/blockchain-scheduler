package br.pucrio.inf.lac.Blockchain;
import java.util.List;

import jota.error.ArgumentException;

public interface Blockchain {
	//	Connect to the specific blockchain
	public boolean Connect();
	
	//	Send data to the specific blockchain
	public void Send(List<br.pucrio.inf.lac.util.Transaction> messages); 
	
	//	Configure the specific blockchain
	public void Configure(String s);
}