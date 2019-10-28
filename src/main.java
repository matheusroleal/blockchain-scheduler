import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import br.pucrio.inf.lac.util.Enqueue;

public class main {

	public main() throws ParseException, InterruptedException{
		Enqueue e = new Enqueue();
	    BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader("/Users/matheus.leal/git/MobileHubTest/src/data-1565977199229.csv"));
			String row;
			while ((row = csvReader.readLine()) != null) {
				String serializableContent = row;
				e.addData(serializableContent);
				TimeUnit.SECONDS.sleep(15);
			}
			System.out.println("acabou");
			csvReader.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) throws ParseException, InterruptedException {
		main f = new main();
	}
}