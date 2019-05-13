import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

//This Controller is the controller class of the AddInfoEnrollment.fxml file.
//Adds Info to the Enrollment Table

public class AddEnrollmentController implements Initializable {

    public TextField studentID;
    public TextField courseID;
    public TextField teacherID;
    public TextField enrollmentID;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        database = a;
        user = b;
        password = c;
    }
    //When apply button is clicked the program connects to the database and adds info to the database
    public void Apply(ActionEvent event) throws IOException{
        String connectionUrl =
                "jdbc:sqlserver://SQL2.cis245.mc3.edu:1433;" +
                        "databaseName="+database+";user="+user+";password="+password;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            //establish connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);

            CallableStatement statement = conn.prepareCall("{call usp_insert_enrollment(?, ?, ?,?)}");

            statement.setString(1, enrollmentID.getText());
            statement.setString(2, studentID.getText());
            statement.setString(3, courseID.getText());
            statement.setString(4, teacherID.getText());
            statement.execute();
            statement.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(rs != null) try { rs.close(); } catch(Exception e) {}
            if(stmt != null) try { stmt.close(); } catch(Exception e) {}
            if(conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }

    // Brings user to the AddInfo.fxml
    public void changeScreenAddInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddInfo.fxml"));
        Parent searchView = loader.load();
        AddInfoController a = loader.<AddInfoController>getController();
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
