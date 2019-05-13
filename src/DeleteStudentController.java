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
// Controller for the DeleteInfoStudent.fxml scene
// Deletes student data
public class DeleteStudentController implements Initializable {
    @FXML
    private ChoiceBox choiceDelete;
    @FXML
    private TextField studentID;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    // When user hits the 'Apply' button the program sees what the user chose form the choiceBox
    // Program then connects to the database and deletes the requested data
    public void Apply(ActionEvent event) throws IOException {
        String connectionUrl =
                "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                        "databaseName=" + database + ";user=" + user + ";password=" + password;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // Deletes data from the Student table
        if (choiceDelete.getValue().toString().equals("Table")) {
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_delete_student_sp(?)}");

                statement.setString(1, studentID.getText());
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
            // Deletes data from the Student table and the Enrollment table
        } else if (choiceDelete.getValue().toString().equals("All")) {
            try {
                //establish connection
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(connectionUrl);

                CallableStatement statement = conn.prepareCall("{call usp_delete_student(?)}");

                statement.setString(1, studentID.getText());
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
       // Brings user back to the Delete.fxml scene when the user hits the 'Back' button
        public void changeSceenDelete(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Delete.fxml"));
            Parent searchView = loader.load();
            DeleteController a = loader.<DeleteController>getController();
            a.data(database,user,password);
            Scene searchScene = new Scene(searchView);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(searchScene);
            window.show();
        }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Adds items to the choiceDelete choicebox
        choiceDelete.getItems().add("Table");
        choiceDelete.getItems().add("All");
    }
}
