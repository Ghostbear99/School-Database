import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
// Controller class for the EditCourse.fxml scene
// Allows user to edit info in the Courses table
public class EditCoursesController implements Initializable {

    @FXML
    private ChoiceBox choice;
    @FXML
    private TextField newinfo;
    @FXML
    private TextField courseID;

    String database;
    String user;
    String password;

    public void data(String a, String b, String c) {
        database = a;
        user = b;
        password = c;
    }
    // Whem the user hits the 'Apply' button the program retrieves which choice the data chose
    // The program then connects to the database
    // Then retrieves data from the textfields and calls the procedure to edit the Courses table
    public void Apply(ActionEvent event) throws IOException {


        if(choice.getValue().toString().equals("Name")){
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

                CallableStatement statement = conn.prepareCall("{call usp_update_course_name(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, courseID.getText());
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

        }else if(choice.getValue().toString().equals("Department")){
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

                CallableStatement statement = conn.prepareCall("{call usp_chg_course_department(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, courseID.getText());
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

        }else if(choice.getValue().toString().equals("Description")){
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

                CallableStatement statement = conn.prepareCall("{call usp_update_course_description(?,?)}");

                statement.setString(1, newinfo.getText());
                statement.setString(2, courseID.getText());
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

            }else if(choice.getValue().toString().equals("Teacher ID")){
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

                    CallableStatement statement = conn.prepareCall("{call usp_update_course_teacher_id(?,?)}");

                    statement.setString(1, newinfo.getText());
                    statement.setString(2, courseID.getText());
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

        }else{

        }

    }
    // Sends the user to the EditInfo.fxml scene when the user hits the 'Back' button
    public void changeSceenBack(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditInfo.fxml"));
        Parent searchView = loader.load();
        EditInfoController a = loader.<EditInfoController>getController();
        a.data(database, user, password);
        Scene searchScene = new Scene(searchView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(searchScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Adds items to the choice ChoiceBox
        choice.getItems().add("Name");
        choice.getItems().add("Department");
        choice.getItems().add("Description");
        choice.getItems().add("Teacher ID");

    }
}

