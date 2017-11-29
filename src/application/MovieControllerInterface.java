package application;

public interface MovieControllerInterface {
	void update(int u);
	void setTickets(int t);
	void setTheatre(String t);
	void setMovie(String t);
	void setPrice(int t);
	
	MovieView getView();
}
