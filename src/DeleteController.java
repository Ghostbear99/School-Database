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
// Controller for the Delete.fxml scene and the hub for the delete interface
public class DeleteController implements Initializable {

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // Sends user to the DeleteinfoStudent.fxml scene when the user hits the 'Student' button
    public void changeSceenDeleteStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteInfoStudent.fxml"));
        Parent searchView = loader.load();
        DeleteStudentController a = loader.<DeleteStudentController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the DeleteCourses.fxml scene when the user hits the 'Courses' button
    public void changeSceenDeleteCourses(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteCourses.fxml"));
        Parent searchView = loader.load();
        DeleteCoursesController a = loader.<DeleteCoursesController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user to the DeleteTeacher.fxml scene when the user hits the 'Teacher' button
    public void changeSceenDeleteTeacher(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteTeacher.fxml"));
        Parent searchView = loader.load();
        DeleteTeacherController a = loader.<DeleteTeacherController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    // Sends the user ot the DeleteEnrollment.fxml scene when the user hits the 'Enrollment' button
    public void changeSceenDeleteEnrollment(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteEnrollment.fxml"));
        Parent searchView = loader.load();
        DeleteEnrollmentController a = loader.<DeleteEnrollmentController>getController();
        a.data(database,user,password);
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
