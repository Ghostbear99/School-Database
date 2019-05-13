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
// Controller for the DisplayTeacher.fxml scene
// Displays data from the Teacher table (database)
public class DisplayTeacherContoller implements Initializable {

    String database;
    String user;
    String password;
    // Creates the teacher table (not database one) and its repective columns
    @FXML
    private TableView<TeacherTable> teacher;
    @FXML
    private TableColumn<TeacherTable, String> teacherID;
    @FXML
    private TableColumn<TeacherTable, String> lastname;
    @FXML
    private TableColumn<TeacherTable, String> firstname;
    @FXML
    private TableColumn<TeacherTable, String> address;
    @FXML
    private TableColumn<TeacherTable, String> state;
    @FXML
    private TableColumn<TeacherTable, String> email;
    @FXML
    private TableColumn<TeacherTable, String> phone;

    ObservableList<TeacherTable> oblist = FXCollections.observableArrayList();



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

            String s = "select * from TEACHER";
            rs = stmt.executeQuery(s);

            while (rs.next()) {
                // Retrieves data from the Teacher table (database)
                oblist.add(new TeacherTable(rs.getString("TEACHER_ID"), rs.getString("LAST_NAME"),
                        rs.getString("FIRST_NAME"), rs.getString("ADDRESS"), rs.getString("STATE"),
                        rs.getString("EMAIL"), rs.getString("PHONE")));
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
        // Tells each column from the teacher table (not database one) where to get their data from the
        // TeacherTable.java class
          teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherid"));
          lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
          firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
          address.setCellValueFactory(new PropertyValueFactory<>("address"));
          state.setCellValueFactory(new PropertyValueFactory<>("state"));
          email.setCellValueFactory(new PropertyValueFactory<>("email"));
          phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

          teacher.setItems(oblist);
    }


}
