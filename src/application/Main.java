package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	private Stage stage;
	private VBox sceneBox;
	private HBox movieListBox, theaterListBox, numofTicketsBox, buttonBox, time;
	private Label movieListLabel, theaterListLabel, numofTicketsLabel, timeLabel;
	private ChoiceBox<String> regalChoiceBox, carmikeChoiceBox, theaterChoiceBox,numofTickets, amcChoiceBox, timeBox;
	private Button purchase,cancel;
	Image cancelImage = new Image("/images/cancelIcon.png",20,20,false,false);
	Image logo = new Image("/images/GSULOGO.png",50,50,false,false);
	
	private double amcPrice = 7.25, regalPrice = 6.50, carmikePrice = 8.25;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane root = new Pane();
		this.stage = stage;
		stage.setTitle("GSU Movie Tickets");
		
		//label for theater choice box
		theaterListLabel = new Label("Theater: ");
		theaterListLabel.setMinWidth(75);
		theaterListLabel.setStyle("-fx-font: 22 Arial;");
		theaterListLabel.setTextFill(Color.GOLDENROD);
		
		//label for movie choice box
		movieListLabel = new Label("Movie: ");
		movieListLabel.setMinWidth(75);
		movieListLabel.setStyle("-fx-font: 22 Arial;");
		movieListLabel.setTextFill(Color.GOLDENROD);
		
		//label for ticket choice box
		numofTicketsLabel = new Label("Tickets: ");
		numofTicketsLabel.setMinWidth(75);
		numofTicketsLabel.setStyle("-fx-font: 22 Arial;");
		numofTicketsLabel.setTextFill(Color.GOLDENROD);
		
		//label for time choice box
		timeLabel = new Label("Time: ");
		timeLabel.setMinWidth(75);
		timeLabel.setStyle("-fx-font: 22 Arial;");
		timeLabel.setTextFill(Color.GOLDENROD);
		
		//button to submit purchase
		purchase = new Button("Purchase Tickets");
		purchase.setStyle("-fx-font: 22 Arial; -fx-base:#a99260; "); 
		
		//cancel order if needed
		cancel = new Button("Cancel", new ImageView(cancelImage));
		cancel.setStyle("-fx-font: 22 Arial; -fx-base:#a99260; "); 
		
		//methods for when the button is pressed
		purchase.setOnAction(e->displayResults());
		cancel.setOnAction(e-> close());
		
		//choice boxes to select different theater, different movies, number of tickets and time
		theaterChoiceBox = new ChoiceBox(FXCollections.observableArrayList("AMC", "Regal", "Carmike"));
		theaterChoiceBox.setTooltip(new Tooltip("Select Theatre"));
		
		amcChoiceBox = new ChoiceBox(FXCollections.observableArrayList("Daddy's Home 2", "IT", "Thor Ragnarok", "Geostorm", "Murder on the Orient Express"));
		amcChoiceBox.setTooltip(new Tooltip("Select Movie"));
		
		regalChoiceBox = new ChoiceBox(FXCollections.observableArrayList("Bad Moms Christmas", "IT", "Thor Ragnarok", "Jigsaw", "Boo A Madea Halloween"));
		regalChoiceBox.setTooltip(new Tooltip("Select Movie"));
		
		carmikeChoiceBox = new ChoiceBox(FXCollections.observableArrayList("Bad Moms Christmas", "Daddy's Home 2", "Thor Ragnarok", "Jigsaw", "Geostorm"));
		carmikeChoiceBox.setTooltip(new Tooltip("Select Movie"));
		
		numofTickets = new ChoiceBox(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
		
		timeBox = new ChoiceBox(FXCollections.observableArrayList("12:00","12:45", "1:30", "2:15", "2:50", "3:35", "4:15", "4:30", "4:45", "6:30", "7:15", "8:30", "9:15"));
		
		theaterListBox = new HBox();
		theaterListBox.setMinWidth(20);
		theaterListBox.getChildren().addAll(theaterListLabel,theaterChoiceBox);
		
		movieListBox = new HBox();
		movieListBox.setMinWidth(20);
		movieListBox.getChildren().addAll(movieListLabel, amcChoiceBox);
		
		numofTicketsBox = new HBox();
		numofTicketsBox.setMinWidth(20);
		numofTicketsBox.getChildren().addAll(numofTicketsLabel,numofTickets);
		
		time = new HBox();
		time.setMinWidth(20);
		time.getChildren().addAll(timeLabel, timeBox);
		
		buttonBox = new HBox();
		buttonBox.getChildren().addAll(purchase, cancel);
		buttonBox.setAlignment(Pos.CENTER);
		
		sceneBox = new VBox(10, theaterListBox,movieListBox, numofTicketsBox,time,buttonBox);
		sceneBox.setPadding(new Insets(30,20,30,20));
		root.getChildren().addAll(sceneBox);
		root.setStyle("-fx-background-color: #041e42;");
		Scene scene = new Scene(root, 440, 280);
		this.stage = stage;
		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons().add(logo);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private Object close() {
		// TODO Auto-generated method stub
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm Cancel");
		alert.setHeaderText("Confirm Cancel");
		alert.setContentText("Are you sure you want to cancel?");
		alert.setGraphic(new ImageView(logo));
		
		Optional<ButtonType>  result = alert.showAndWait();
		if(result.get() == ButtonType.OK) {
			System.exit(0);
		}
		return 0;
	}


	private Object displayResults() {
		// TODO Auto-generated method stub
		String theater = theaterChoiceBox.getSelectionModel().getSelectedItem();
		double price, total = 0;
		String movie = amcChoiceBox.getSelectionModel().getSelectedItem();
		int tickets = (numofTickets.getSelectionModel().getSelectedIndex()) + 1;
		String time = timeBox.getSelectionModel().getSelectedItem();
		Alert alert = new Alert(AlertType.INFORMATION);
		Alert err = new Alert(AlertType.WARNING);
		alert.setTitle("Ticket Confirmation");
		alert.setHeaderText("Your Order");
		alert.setGraphic(new ImageView(logo));
		
		err.setTitle("WARNING");
		err.setHeaderText("WARNING");
		err.setGraphic(new ImageView(logo));
		
		if(theater == "" || movie == "" || tickets == 0 || time == "") {
			err.setContentText("You left something empty, review your order");
			err.showAndWait();
		}
		else {
			if(theater == "AMC" ) {
				MovieTheater amc = new FromAMC();
				
				alert.setContentText("Theater: " + amc.getName() + "\nMovie: " + amc.getMovie(movie) + "\nTime: " + amc.getTime(time) + "pm\nNum of Tickets: " + amc.getTickets(tickets) + "\nTotal: $" + amc.getTotal());
				alert.showAndWait();
			}
			else if(theater == "Regal" ) {
				MovieTheater reg = new FromRegal();
				
				alert.setContentText("Theater: " + reg.getName() + "\nMovie: " + reg.getMovie(movie) + "\nTime: " + reg.getTime(time) + "pm\nNum of Tickets: " + reg.getTickets(tickets) + "\nTotal: $" + reg.getTotal());
				alert.showAndWait();
			}
			else if(theater == "Carmike" ) {
				MovieTheater car = new FromCarmike();
				
				alert.setContentText("Theater: " + car.getName() + "\nMovie: " + car.getMovie(movie) + "\nTime: " + car.getTime(time) + "pm\nNum of Tickets: " + car.getTickets(tickets) + "\nTotal: $" + car.getTotal());
				alert.showAndWait();
			}
		}
		return total;
	}
}
