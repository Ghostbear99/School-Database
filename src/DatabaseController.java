import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// This is the Controller for Main Menu.fxml. This is the hub for the whole program's interface
//Sends users to different areas; delete, add, change, and display
public class DatabaseController implements Initializable {

    String database;
    String user;
    String password;

    // Receives credentials from whichiver scene calls 'Main Menu.fxml'
    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // Sends user to the Display.fxml scene when the user hits the 'Display' button
    public void changeSceenDisplay(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Display.fxml"));
        Parent searchView = loader.load();
        DisplayController a = loader.<DisplayController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends user to the Delete.fxml scene when user hits the 'Delete' button
    public void changeSceenDelete(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Delete.fxml"));
        Parent searchView = loader.load();
        DeleteController a  = loader.<DeleteController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends user to the EditInfo.fxml scene when the user hits the 'Change' button
    public void changeSceenEdit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditInfo.fxml"));
        Parent searchView = loader.load();
        EditInfoController a = loader.<EditInfoController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends user to the AddInfo.fxml scene when the user hits the 'Add' button
    public void changeSceenAdd(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfo.fxml"));
        Parent searchView = loader.load();
        AddInfoController a = loader.<AddInfoController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
