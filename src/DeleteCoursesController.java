import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
// Controller for the DeleteCourses.fxml scene
// Deletes courses data
public class DeleteCoursesController implements Initializable {

    @FXML
    private TextField courseID;
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
    // When user hits apply the program retrieves what the user chose from the choicebox
    // The program then connects to the database and deltes the requested data
    public void Apply(ActionEvent event) throws IOException{
        // Deletes the courses data from the Courses table
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


                CallableStatement statement = conn.prepareCall("{call usp_delete_courses_sp(?)}");

                statement.setString(1, courseID.getText());
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
            // Deletes the courses data from the Courses table and Enrollment table
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

                CallableStatement statement = conn.prepareCall("{call usp_delete_courses(?)}");

                statement.setString(1, courseID.getText());
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
    // Sends user to the Delete.fxml Scene when the user hits the 'Back' button
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
        // Adding items to the choiceDelete choicebox
        choiceDelete.getItems().add("Table");
        choiceDelete.getItems().add("All");
    }
}
