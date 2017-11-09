package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private Stage stage;
	private VBox sceneBox;
	private HBox movieListBox, theatreListBox, numofTicketsBox, buttonBox;
	private Label movieListLabel, theatreListLabel, numofTicketsLabel;
	private TextField numofTickets;
	private ChoiceBox<String> movieChoiceBox, theatreChoiceBox;
	private Button purchase,cancel;
	private int maxTickets = 10;
	
	private double amcPrice = 7.25, regalPrice = 6.50, carmike = 8.25;

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		this.stage = stage;
		stage.setTitle("GSU Movie Tickets");
		
		theatreListLabel = new Label("Theatre: ");
		theatreListLabel.setMinWidth(75);
		theatreListLabel.setStyle("-fx-font: 22 Arial;");
		
		movieListLabel = new Label("Movie: ");
		movieListLabel.setMinWidth(75);
		movieListLabel.setStyle("-fx-font: 22 Arial;");
		
		numofTicketsLabel = new Label("Tickets: ");
		numofTicketsLabel.setMinWidth(75);
		numofTicketsLabel.setStyle("-fx-font: 22 Arial;");
		
		numofTickets = new TextField();
		numofTickets.setPrefColumnCount(4);
		numofTickets.setTooltip(new Tooltip("Enter number of tickets"));
		
		purchase = new Button("Purchase Tickets");
		purchase.setStyle("-fx-font: 22 Arial; -fx-base:#a99260; "); 
		
		Image cancelImage = new Image("/images/cancelIcon.png",20,20,false,false);
		cancel = new Button("Cancel", new ImageView(cancelImage));
		cancel.setStyle("-fx-font: 22 Arial; -fx-base:#a99260; "); 
	
		purchase.setOnAction(e->displayResults());
		cancel.setOnAction(e-> close());
		
		theatreChoiceBox = new ChoiceBox(FXCollections.observableArrayList("AMC", "Regal", "Carmike"));
		theatreChoiceBox.setTooltip(new Tooltip("Select Theatre"));
		
		movieChoiceBox = new ChoiceBox(FXCollections.observableArrayList("Daddy's Home 2", "IT", "Thor Ragnarok", "Geostorm", "Murder on the Orient Express"));
		movieChoiceBox.setTooltip(new Tooltip("Select Movie"));
		
		theatreListBox = new HBox();
		theatreListBox.setMinWidth(20);
		theatreListBox.getChildren().addAll(theatreListLabel,theatreChoiceBox);
		
		movieListBox = new HBox();
		movieListBox.setMinWidth(20);
		movieListBox.getChildren().addAll(movieListLabel,movieChoiceBox);
		
		numofTicketsBox = new HBox();
		numofTicketsBox.setMinWidth(20);
		numofTicketsBox.getChildren().addAll(numofTicketsLabel,numofTickets);
		
		buttonBox = new HBox();
		buttonBox.getChildren().addAll(purchase, cancel);
		
		sceneBox = new VBox(10, theatreListBox,movieListBox, numofTicketsBox,buttonBox);
		sceneBox.setPadding(new Insets(30,20,30,20));
		
		Scene scene = new Scene(sceneBox, 440, 280);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	private Object close() {
		// TODO Auto-generated method stub
		return null;
	}


	private Object displayResults() {
		// TODO Auto-generated method stub
		double price = 7.50;
		double total = 0;
		int tickets = 0;
		String movie = movieChoiceBox.
	}
}
