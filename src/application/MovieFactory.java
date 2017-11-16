package application;

import java.util.ArrayList;

public class MovieFactory implements MovieInterface{
	//model
	private static MovieFactory movie;
	
	//variables and state based on user input
	private int state = 0, tickets;
	private String amc = "AMC"; 
	private String regal = "Regal";
	private String carmike = "Carmike";
	private double price,total;
	
	ArrayList<StateObserver> observers = new ArrayList<StateObserver>();
	//movie theater class variable
	MovieTheater theater;
	
	private MovieFactory() {
		System.setProperty("theaterFrom", "NullTheater");
	}
	
	@Override
	//method for selecting the theater
	public String getTheatre() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String s = System.getProperty("theaterFrom");
		theater = (MovieTheater)Class.forName(s).newInstance();
		return null;
	}

	@Override
	public void setTheatre(String t) {
		// TODO Auto-generated method stub
		System.setProperty("theaterFrom", "From" + t);
	}
	//method to get prices based on the theater selected
	public double getPrice() {
		if(state==1) {
			return theater.getPrice(price);
		}
		else if(state==2) {
			return theater.getPrice(price);
		}
		else if(state==3) {
			return theater.getPrice(price);
		}
		notifyStateObservers();
		return (Double) null;
	}
	
	public void setPrice(double p) {
		this.price = p;
	}
	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		state = 7;
		notifyStateObservers();
		return theater.getTotal();
	}

	@Override
	public void setTotal(double t) {
		// TODO Auto-generated method stub
		this.total = t;
	}

	@Override
	public void setTickets(int t) {
		// TODO Auto-generated method stub
		this.tickets = t;
	}

	@Override
	public int getTickets() {
		// TODO Auto-generated method stub
		state = 7;
		notifyStateObservers();
		return theater.getTickets(tickets);
	}

	@Override
	//method for getting movies based on what theater is selected
	public String getMovie() {
		// TODO Auto-generated method stub
		if(state==4) {
			return theater.getMovie(amc);
		}
		else if(state==5) {
			return theater.getMovie(regal);
		}
		else if(state==6) {
			return theater.getMovie(carmike);
		}
		return null;
	}

	@Override
	public void setMovie(String m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerObserver(StateObserver o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(StateObserver o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	@Override
	public void update(int u) {
		// TODO Auto-generated method stub
		if(state==0) {
			if(u==1) {
				state = 1;
			}
			else if(u==2) {
				state = 2;
			}
			else if(u==3) {
				state = 3;
			}
		}
		notifyStateObservers();
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int s) {
		this.state = s;
		notifyStateObservers();
	}
	
	private void notifyStateObservers() {
		for(int i=0; i<observers.size();i++) {
			StateObserver observer = (StateObserver)observers.get(i);
			observer.update();
		}
	}
	
	//Singleton method for only 1 instance at a time
	public synchronized static MovieFactory getInstance() {
		if(movie == null) {
			movie = new MovieFactory();
		}
		return movie;
	}

	
}

