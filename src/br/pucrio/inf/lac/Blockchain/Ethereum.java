package br.pucrio.inf.lac.Blockchain;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import br.pucrio.inf.lac.Blockchain.smartcontract.StoreData;
import br.pucrio.inf.lac.util.Transaction;

public class Ethereum implements Blockchain {

	private String eth_port;
	private String eth_url;

	Web3j web3;
	StoreData contract;
	Credentials credentials;

	public Ethereum(String url, String port) {
		eth_port = port;
		eth_url = url;
		
		credentials = Credentials.create("20eefd03416671a858ca1021c083047427996e565da49af318382919f15be93a");
	}

	public boolean Connect() {
		web3 = Web3j.build(new HttpService("https://"+eth_url));

		try {
			
			// web3_clientVersion returns the current client version.
			Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

			// eth_blockNumber returns the number of most recent block.
			EthBlockNumber blockNumber = web3.ethBlockNumber().send();

			// eth_gasPrice, returns the current price per gas in wei.
			EthGasPrice gasPrice = web3.ethGasPrice().send();

			// Print result
			System.out.println("Client version: " + clientVersion.getWeb3ClientVersion());
			System.out.println("Block number: " + blockNumber.getBlockNumber());
			System.out.println("Gas price: " + gasPrice.getGasPrice());

			return true;

		} catch (IOException ex) {
			throw new RuntimeException("Error whilst sending json-rpc requests", ex);
		}

	}

	public void Send(List<Transaction> messages) {		
		
    	System.out.println(new Timestamp(System.currentTimeMillis()));

    	messages.forEach(message -> {
			TransactionReceipt result;
			try {
				result = contract.setTransaction(message.getData()).send();
				System.out.println(result.getBlockHash());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

    	System.out.println(new Timestamp(System.currentTimeMillis()));
	}

	public void Configure(String s) {
		try {
			contract = StoreData.deploy(web3, credentials, new DefaultGasProvider()).send();
			String contractAddress = contract.getContractAddress();

			System.out.println(contractAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
