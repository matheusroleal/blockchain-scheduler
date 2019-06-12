import jota.IotaAPI;
import jota.dto.response.GetNodeInfoResponse;

public class IOTA implements Blockchain {
	
	private String iota_url;
	private String iota_port;
	
	public IOTA(String url, String port) {
		iota_port = url;
		iota_url = port;
	}
    
	public boolean Connect() {
		IotaAPI api = new IotaAPI.Builder()
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
 
    public void Send() {
        // TODO Auto-generated method stub
    }
 
    public void Configure() {
        // TODO Auto-generated method stub
    }

}
