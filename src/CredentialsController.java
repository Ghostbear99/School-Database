import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Grabs the credentials the user entered and passes them to the database controller through the DatabaseController
public class CredentialsController implements Initializable {
    public TextField database;
    public TextField user;
    public TextField password;

    // When user hits the 'Apply' button the program sends the credentials the user entered to the Main Menu.fxml Scene
    // through its controller 'Database Controller'
    public void changeScreenMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main Menu.fxml"));
        Parent searchView = loader.load();
        DatabaseController a = loader.<DatabaseController>getController();
        a.data(database.getText(), user.getText(), password.getText());
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
