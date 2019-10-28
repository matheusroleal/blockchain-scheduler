package br.pucrio.inf.lac.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.UUID;

public class Enqueue {
	
	Scheduler s;
	
	public Enqueue() {
		s = new Scheduler();
	}
	
	public void addData(String d) {
        // Creating a random Universally Unique identifier for the transaction
        UUID uuid = UUID.randomUUID();

        String randomUUIDString = uuid.toString();
        
        // Get current data		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		
		Date date = new Date();
		
		// Creating new transaction		
		Transaction t;
		try {
			t = new Transaction(randomUUIDString.toString(),d,dateFormat.format(date).toString());
			s.enqueue_in(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
