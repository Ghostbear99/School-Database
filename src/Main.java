import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;
//Main Class of the Final Project project
public class Main extends Application {
        public static void main(String[] args) {
            launch(args);


        }
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("School Database");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Credentials.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
