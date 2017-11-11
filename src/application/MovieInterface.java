package application;

public interface MovieInterface {
	String getTheatre();
	void setTheatre(String t);
	int getTotal();
	int getTickets();
	void registerObservers(StateObserver o);
	void removeObservers(StateObserver o);
	int getState();
}
