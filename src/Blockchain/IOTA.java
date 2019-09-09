package Blockchain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jota.IotaAPI;
import jota.dto.response.GetNewAddressResponse;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Transfer;
import jota.utils.TrytesConverter;

public class IOTA implements Blockchain {
	
	IotaAPI api;
	
	// Variables for the API	
	private String iota_url;
	private String iota_port;
	
	// Variables for the Sender	
	private String tag;
	private String address;
	private String seed;
	private int Depth;
	private int MinWeightMagnitude;
	
	public IOTA(String url, String port) {
		iota_port = port;
		iota_url = url;
		Depth = 4; // constant defined by IOTA - how deep to look for the tips in the Tangle
		MinWeightMagnitude = 14; // constant defined by IOTA - the difficulty of PoW
		tag = "JOTASPAM9999999999999999999";
	}
    
	public boolean Connect() {

		api = new IotaAPI.Builder()
		        .host(iota_url)
		        .protocol("https")
		        .port(iota_port)
		        .build();

		GetNodeInfoResponse response = api.getNodeInfo();
				
		if(response != null) {
			return true;
		}

		return false;
    }
 
    public void Send(List<util.Transaction> messages) {
    	List<Transfer> transfers = new ArrayList<>();
    	
    	System.out.println(new Timestamp(System.currentTimeMillis()));
    	
    	messages.forEach(message->{
    		transfers.add(new Transfer(address, 0, StringUtils.rightPad(TrytesConverter.toTrytes(message.getData()), 2188, '9'), tag));
    	});

    	try {
			SendTransferResponse res = api.sendTransfer(seed, 2, Depth, MinWeightMagnitude, transfers, null, null, false);
    		if(res.getSuccessfully() != null){
    	    	System.out.println(new Timestamp(System.currentTimeMillis()));
    		}
    	} catch (ArgumentException e) {
			e.printStackTrace();
		}  
    }


	public void Configure(String s) {
    	seed = s;

    	// Define Address    	
		try {
			GetNewAddressResponse a = api.getNewAddress(seed, 2, 0, true, 9, true);
			address = a.getAddresses().get(0);
		} catch (ArgumentException e) {
			e.printStackTrace();
		}
    }

}
