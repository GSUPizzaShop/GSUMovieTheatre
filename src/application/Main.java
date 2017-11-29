package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	MovieInterface model = MovieFactory.getInstance();
	MovieControllerInterface controller = new MovieController(model);
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		MovieView movieView = controller.getView();
		movieView.createView();
		primaryStage.setScene(movieView.scene);
		primaryStage.show();
	}
}
