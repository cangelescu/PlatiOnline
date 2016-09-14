package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

@SuppressWarnings("unused")
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/screen/LoginPanel.fxml"));
			// dimensiunea ferestrei si "radacina" sau "Parent"
			Scene scene = new Scene(root, 350, 500);
			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(350);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(350);

			scene.getStylesheets().add(getClass().getResource("/screen/application.css").toExternalForm());
			// setare scena si afisare
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final int PORT = 8899;

	public static void main(String[] args) {
		launch(args);
	}
}
