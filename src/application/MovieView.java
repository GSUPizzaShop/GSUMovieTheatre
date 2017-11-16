package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieView{
	MovieInterface model;
	MovieControllerInterface control;
	private int state;
	
	//building
	private Stage stage;
	private VBox sceneBox;
	private HBox movieListBox, theaterListBox, numofTicketsBox, buttonBox, time;
	private Label movieListLabel, theaterListLabel, numofTicketsLabel, timeLabel;
	private Button purchase,cancel;
	Image cancelImage = new Image("/images/cancelIcon.png",20,20,false,false);
	Image logo = new Image("/images/GSULOGO.png",50,50,false,false);
}
