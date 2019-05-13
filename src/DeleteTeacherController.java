import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
// Controller class for the DeleteTeacher.fxml scene
// Deletes teacher data
public class DeleteTeacherController implements Initializable {

    @FXML
    private TextField teacherID;
    @FXML
    private ChoiceBox choiceDelete;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // When user hits the 'Apply' button the program retrieves what the user chsoe
    // Program then connects to the database and deletes the requested data
    public void Apply(ActionEvent event) throws IOException{
        // Deletes data from the Teacher table
        if (choiceDelete.getValue().toString().equals("Table")) {
            String connectionUrl =
                    "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                            "databaseName=" + database + ";user=" + user + ";password=" + password;

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_delete_teacher_sp(?)}");

                statement.setString(1, teacherID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
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
            // Deletes data from the Teacher table, Courses table, and Enrollment table
        } else if (choiceDelete.getValue().toString().equals("All")) {
            String connectionUrl =
                    "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                            "databaseName=" + database + ";user=" + user + ";password=" + password;

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);


                CallableStatement statement = conn.prepareCall("{call usp_delete_teacher(?)}");

                statement.setString(1, teacherID.getText());
                statement.execute();
                statement.close();

            } catch (Exception e) {
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
        } else {

        }
    }
    // Sends user back to the Delete.fxml scene when the user hits hte 'Back' button
    public void changeSceenDelete(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Delete.fxml"));
        Parent searchView = loader.load();
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Adds items to the choiceDelete ChoiceBox
        choiceDelete.getItems().add("Table");
        choiceDelete.getItems().add("All");
    }
}
