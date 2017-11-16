package application;

public class NullTheater implements MovieTheater{

	@Override
	public double getPrice(double p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getMovie(String m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTickets(int t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTime(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
