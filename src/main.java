import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import util.Enqueue;

public class main {

	public main() throws ParseException, InterruptedException{
		Enqueue e = new Enqueue();
		e.addData("matheus");
		TimeUnit.MINUTES.sleep(1);
		e.addData("leal");
	}

	public static void main(String[] args) throws ParseException, InterruptedException {
		main f = new main();
	}
}