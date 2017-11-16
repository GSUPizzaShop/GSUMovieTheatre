package application;

public interface MovieInterface {
	//get and set theater
	String getTheatre() throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	void setTheatre(String t);
	//get and set price based on theater
	double getPrice();
	void setPrice(double p);
	//get and set the total
	double getTotal();
	void setTotal(double t);
	//get and set the number of tickets
	void setTickets(int t);
	int getTickets();
	//get and set the movie
	String getMovie();
	void setMovie(String m);
	//adding and removing observers
	void registerObserver(StateObserver o);
	void removeObserver(StateObserver o);
	//update based on input
	void update(int u);
	//get and set state
	int getState();
	void setState(int s);
	
	
}
