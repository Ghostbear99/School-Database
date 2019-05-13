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

public class AddInfoController implements Initializable {

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // Brings user back to the Main Menu.fxml
    public void changeScreenMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main Menu.fxml"));
        Parent searchView = loader.load();
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Brings user to the AddInfoStudent.fxml
    public void changeScreenStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfoStudent.fxml"));
        Parent searchView = loader.load();
        AddInfoStudentController a = loader.<AddInfoStudentController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Brings user to the AddInfoTeacher.fxml
    public void changeScreenTeacher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfoTeacher.fxml"));
        Parent searchView = loader.load();
        AddInfoTeacherController a = loader.<AddInfoTeacherController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Brings user to the AddInfoCourses.fxml
    public void changeScreenCourses(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfoCourses.fxml"));
        Parent searchView = loader.load();
        AddInfoCoursesController a = loader.<AddInfoCoursesController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    //Brings user to the AddInfoEnrollment.fxml
    public void changeScreenEnrollment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfoEnrollment.fxml"));
        Parent searchView = loader.load();
        AddEnrollmentController a = loader.<AddEnrollmentController>getController();
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
