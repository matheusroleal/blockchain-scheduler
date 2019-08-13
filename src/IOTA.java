import java.util.ArrayList;
import java.util.List;

import jota.IotaAPI;
import jota.dto.response.GetNewAddressResponse;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Input;
import jota.model.Transfer;

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
		iota_port = url;
		iota_url = port;
		Depth = 3; // constant defined by IOTA - how deep to look for the tips in the Tangle
		MinWeightMagnitude = 16; // constant defined by IOTA - the difficulty of PoW
	}
    
	public boolean Connect() {
		api = new IotaAPI.Builder()
		        .protocol("http")
		        .host(iota_url)
		        .port(iota_port)
		        .build();
		
		GetNodeInfoResponse response = api.getNodeInfo();
		
		if(response != null) {
			return true;
		}

		return false;
    }
 
    public void Send(String message) {
    	List<Transfer> transfers = new ArrayList<>();
    	Transfer t = new Transfer(address,0,message,tag);
    	transfers.add(t);

    	
    	List<Input> inputs = new ArrayList<>();
    	Input opt = new Input(address, 1, 0, 0);
    	inputs.add(opt);
    	
    	try {
			SendTransferResponse res = api.sendTransfer(seed, 0, Depth, MinWeightMagnitude, transfers, inputs, address, true);
			System.out.println(res.getSuccessfully());
    	} catch (ArgumentException e) {
			e.printStackTrace();
		}
    }
 
    public void Configure(String s) {
    	
    	seed = s;
    	
    	// Define Address    	
    	GetNewAddressResponse a = null;
		try {
			a = api.getNewAddress(seed, 0, 1, true, 9, true);
		} catch (ArgumentException e) {
			e.printStackTrace();
		}
    	address = a.getAddresses().get(0);
    }

}
