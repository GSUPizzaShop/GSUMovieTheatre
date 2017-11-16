package application;

public class FromCarmike implements MovieTheater{
	double price = 7.25;
	int tickets;
	String time;
	
	@Override
	public double getPrice(double p) {
		// TODO Auto-generated method stub
		this.price = p;
		return price;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return (int) (price * tickets);
	}

	@Override
	public int getTickets(int t) {
		// TODO Auto-generated method stub
		this.tickets = t;
		return tickets;
	}

	@Override
	public String getMovie(String m) {
		// TODO Auto-generated method stub
		return m;
	}

	public String getName() {
		return "Carmike";
	}
	
	public String getTime(String t) {
		this.time = t;
		return time;
	}
}
