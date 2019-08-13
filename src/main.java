import java.text.ParseException;

public class main {

	public main() throws ParseException, InterruptedException{
		Scheduler s = new Scheduler();
		Transaction t = new Transaction(1,"sadasdadas","31-Dec-1998 23:37:50");
		s.enqueue_in(t);
		Thread.sleep(10000);
		Transaction t2 = new Transaction(2,"sad1ssadas","31-Dec-1998 21:37:50");
		s.enqueue_in(t2);
	}

	public static void main(String[] args) throws ParseException, InterruptedException {
		main f = new main();
	}
}