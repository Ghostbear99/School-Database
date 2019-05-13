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
// Controller for the DisplayStudent.fxml scene
// Displays data from the Student table (database)
public class DisplayStudentController implements Initializable {

    String database;
    String user;
    String password;
    // Creates the student table (not database one) and its respectve columns
    @FXML
    private TableView<StudentTable> student;
    @FXML
    private TableColumn<StudentTable, String> studentID;
    @FXML
    private TableColumn<StudentTable, String> lastname;
    @FXML
    private TableColumn<StudentTable, String> firstname;
    @FXML
    private TableColumn<StudentTable, String> address;
    @FXML
    private TableColumn<StudentTable, String> state;
    @FXML
    private TableColumn<StudentTable, String> phone;
    @FXML
            private TableColumn<StudentTable, String> grade;

    ObservableList<StudentTable> ablist = FXCollections.observableArrayList();



    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }


    // Sends user to the Display.fxml scene when the user hits the 'Back' button
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
        // Connects to the database
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

            String s = "select * from STUDENT";
            rs = stmt.executeQuery(s);

            while (rs.next()) {
                // Getting the data from the Student table from database
                ablist.add(new StudentTable(rs.getString("STUDENT_ID"), rs.getString("LAST_NAME"),
                        rs.getString("FIRST_NAME"), rs.getString("ADDRESS"), rs.getString("STATE"),
                        rs.getString("PHONE"), rs.getString("AVERAGE_GRADE")));
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
        // Telling each column from the student table (not database table) where to get their values from the
        // StudentTable.java class
        studentID.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        state.setCellValueFactory(new PropertyValueFactory<>("state"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        student.setItems(ablist);
    }


}
