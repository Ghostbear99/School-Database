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
// Controller class for the Display.fxml scene
// Hub for the display part of the program
public class DisplayController implements Initializable {

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // Sends the user to the DisplayStudent.fxml scene when the user htis the 'Student'button
    public void changeSceenDisplayStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayStudent.fxml"));
        Parent searchView = loader.load();
        DisplayStudentController a = loader.<DisplayStudentController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to teh DisplayCourses.fxml scene when the user hits the 'Courses' button
    public void changeSceenDisplayCourses(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayCourses.fxml"));
        Parent searchView = loader.load();
        DisplayCoursesController a = loader.<DisplayCoursesController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the DisplayTeacher.fxml scene when the user hits the 'Teacher' button
    public void changeSceenDisplayTeacher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayTeacher.fxml"));
        Parent searchView = loader.load();
        DisplayTeacherContoller a = loader.<DisplayTeacherContoller>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the DisplayEnrollment.fxml scene when the user hits the 'Enrollment' button
    public void changeSceenDisplayEnrollment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayEnrollment.fxml"));
        Parent searchView = loader.load();
        DisplayEnrollmentController a = loader.<DisplayEnrollmentController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the Main Menu.fxml when the user hits the 'Main Menu' button
    public void changeSceenMain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main Menu.fxml"));
        Parent searchView = loader.load();
        DatabaseController a = loader.<DatabaseController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}


