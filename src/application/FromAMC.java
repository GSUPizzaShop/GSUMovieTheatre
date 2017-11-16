package application;

public class FromAMC implements MovieTheater{
	double price = 7.25;
	int tickets;
	
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
	public int getTickets() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMovie(String m) {
		// TODO Auto-generated method stub
		return null;
	}

}
