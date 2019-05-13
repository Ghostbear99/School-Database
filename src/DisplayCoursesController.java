import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
// Controller for the DisplayCourse.fxml scene
// Displays the data from the Courses table
public class DisplayCoursesController implements Initializable {
    String database;
    String user;
    String password;

    // Creating the course table and columns
    @FXML
    private TableView<CourseTable> course;
    @FXML
    private TableColumn<CourseTable, String> courseID;
    @FXML
    private TableColumn<CourseTable, String> name;
    @FXML
    private TableColumn<CourseTable, String> department;
    @FXML
    private TableColumn<CourseTable, String> description;
    @FXML
    private TableColumn<CourseTable, String> teacherID;

    ObservableList<CourseTable> cblist = FXCollections.observableArrayList();



    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }


    // Sends the user to the Display.fxml scene when the user hits the 'Back' button
    public void changeSceenBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Display.fxml"));
        Parent searchView = loader.load();
        DisplayController a = loader.<DisplayController>getController();
        a.data(database,user,password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Connects to the database and displays the data
        String connectionUrl =
                "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                        "databaseName=z_DB07;user=user07;password=Spartan!117";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);

            //---------------------------
            //CREATE a query statement variable to execute queries
            stmt = conn.createStatement();

            String s = "select * from COURSES";
            rs = stmt.executeQuery(s);

            while (rs.next()) {
                // Getting data from Courses table in database
                cblist.add(new CourseTable(rs.getString("COURSE_ID"), rs.getString("NAME"),
                        rs.getString("DEPARTMENT"), rs.getString("DESCRIPTION"), rs.getString("TEACHER_ID")));
            }
            conn.close();
        }//end try
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
        // Telling each column in the course table (not database one) where to get their values from the CourseTable.java
        courseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));

        course.setItems(cblist);
    }

}
