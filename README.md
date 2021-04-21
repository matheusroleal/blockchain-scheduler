# Blockchain Scheduler
This project aims to create a scheduler to send transactions to a blockchain of your choice.

## Blockchain Interface

An interface in the Java programming language is an abstract type that is used to specify behavior that classes should implement. In this project we use this structure to create a model that any Blockchain to be implemented should use. Making the interaction between the queue and the Blockchain generic.

```
public interface Blockchain {
	//Connect to the specific blockchain
	public boolean Connect();
	
	//Send data to the specific blockchain
	public void Send(List<br.pucrio.inf.lac.util.Transaction> messages); 
	
	//Configure the specific blockchain
	public void Configure(String s);
}
```
### Integrated Blockchains
- [IOTA](https://github.com/matheusroleal/blockchain-scheduler/blob/master/src/br/pucrio/inf/lac/Blockchain/IOTA.java)
- [IoTex](https://github.com/matheusroleal/blockchain-scheduler/blob/master/src/br/pucrio/inf/lac/Blockchain/IoTex.java)
- [Ethereum](https://github.com/matheusroleal/blockchain-scheduler/blob/master/src/br/pucrio/inf/lac/Blockchain/Ethereum.java)
