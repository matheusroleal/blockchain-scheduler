
public interface Blockchain {
	//	Connect to the specific blockchain
	public boolean Connect();
	
	//	Send data to the specific blockchain
	public void Send(); 
	
	//	Configure the specific blockchain
	public void Configure();
}