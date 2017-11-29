package application;

public class MovieController implements MovieControllerInterface {
	MovieInterface model;
	MovieView view;
	
	public MovieController(MovieInterface model) {
		this.model = model;
		view = new MovieView(this, model);
	}

	@Override
	public void update(int u) {
		model.update(u);
	}

	@Override
	public void setTickets(int t) {
		model.setTickets(t);
	}

	@Override
	public void setTheatre(String t) {
		model.setTheatre(t);
	}

	@Override
	public void setMovie(String t) {
		model.setMovie(t);
	}

	@Override
	public void setPrice(int t) {
		model.setPrice(t);
	}

	@Override
	public MovieView getView() {
		return view;
	}

}
