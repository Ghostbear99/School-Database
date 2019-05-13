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
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// Adds info to the teacher table
public class AddInfoTeacherController implements Initializable {
    @FXML
    private TextField teacherID;
    @FXML
    private TextField lastname;
    @FXML
    private TextField firstname;
    @FXML
    private TextField address;
    @FXML
    private TextField state;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c){
        System.out.println(a + b + c);
        database = a;
        user = b;
        password = c;
    }
    //When user hits the 'Apply' button then the the program connects to the database
    //The program grabs the info the user entered in the TextField's
    //The program then adds that data to the Teacher Table
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

            CallableStatement statement = conn.prepareCall("{call usp_insert_teacher(?, ?, ?, ?, ?, ?, ?)}");

            statement.setString(1, teacherID.getText());
            statement.setString(2, lastname.getText());
            statement.setString(3, firstname.getText());
            statement.setString(4, address.getText());
            statement.setString(5, state.getText());
            statement.setString(6, email.getText());
            statement.setString(7, phone.getText());
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
    // When the user hits the 'Back' button the progrram sends the user back to AddInfo.fxml Scene
    public void changeScreenBack(ActionEvent event) throws IOException {
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
