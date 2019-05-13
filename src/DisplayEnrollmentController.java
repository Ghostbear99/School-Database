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
// Controller class for the DisplayEnrollment.fxml scene
// Displays data from the Enrollment table
public class DisplayEnrollmentController implements Initializable {
    String database;
    String user;
    String password;

    // Creates the enrollment table for the interface (not database table) and its respective columns
    @FXML
    private TableView<EnrollmentTable> enrollment;
    @FXML
    private TableColumn<EnrollmentTable, String> enrollmentID;
    @FXML
    private TableColumn<EnrollmentTable, String> studentID;
    @FXML
    private TableColumn<EnrollmentTable, String> courseID;
    @FXML
    private TableColumn<EnrollmentTable, String> teacherID;


    ObservableList<EnrollmentTable> eblist = FXCollections.observableArrayList();




    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }



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
        // Conntects to the database
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

            String s = "select * from ENROLLMENT";
            rs = stmt.executeQuery(s);

            while (rs.next()) {
                // Gets data from the Enrollment table
                eblist.add(new EnrollmentTable(rs.getString("ENROLLMENT_ID"), rs.getString("STUDENT_ID"), rs.getString("COURSE_ID"),
                        rs.getString("TEACHER_ID")));
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
        // Telling each column in the enrollment table (not database one) where to get their data from the
        // EnrollmentTable.java
        enrollmentID.setCellValueFactory(new PropertyValueFactory<>("enrollmentID"));
        studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        courseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));

        enrollment.setItems(eblist);
    }
}
