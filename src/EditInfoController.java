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
// Controller fo the EditInfo.fxml scene
// Hub for the edit section of the program
public class EditInfoController implements Initializable {


    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // Sends user to the EditStudent.fxml when the user hits the 'Student' button
    public void changeSceenEditStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditStudent.fxml"));
        Parent searchView = loader.load();
        EditStudentController a = loader.<EditStudentController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the use to the EditTeacher.fxml scene when the user hits the 'Teacher' button
    public void changeSceenEditTeacher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTeacher.fxml"));
        Parent searchView = loader.load();
        EditTeacherController a = loader.<EditTeacherController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the EditCourse.fxml scene when the user hits the 'Course' button
    public void changeSceenEditCourses(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditCourse.fxml"));
        Parent searchView = loader.load();
        EditCoursesController a  = loader.<EditCoursesController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the Main Menu.fxml scene when the user hits the 'Main Menu' button
    public void changeSceenMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main Menu.fxml"));
        Parent searchView = loader.load();
        DatabaseController a = loader.<DatabaseController>getController();
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
