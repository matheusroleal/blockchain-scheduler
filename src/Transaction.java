import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	private String id;
	private String data;
	private Date date;
	
	public Transaction(String i,String d, String dt) throws ParseException {
		id = i;
		data = d;
		date = convertDate(dt);
	}
	
	public String getData() {
		return data;
	}
	
	public String getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	private Date convertDate(String dt) throws ParseException {
	    SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
		return formatter.parse(dt);
	}
}
